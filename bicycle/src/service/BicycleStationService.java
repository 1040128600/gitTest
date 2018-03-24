package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.BicycleStationDao;
import iservice.IBicycleStationService;
import model.Bicycle_info;
import model.Bicycle_pile;
import model.Bicycle_station;

import util.Page;
import util.ResultBean;
import util.StringUtil;

import static util.ResultBean.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BicycleStationService implements IBicycleStationService {

	@Autowired
	private BicycleStationDao dao;
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ResultBean<Object> addOneStation(Bicycle_station station) {
		// TODO 自动生成的方法存根
		System.out.println("+++++++++++++++++++++++add"+station);
		try {
			StringUtil.transToSpace(station);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int n=dao.addOneStation(station);
		if(station.getPiles()!=null){
			station.getPiles().forEach(pile->{if(pile!=null){
				try {
					StringUtil.transToSpace(pile);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				pile.setStation_Id(station.getStation_Id());

				dao.addOnePile(pile);
			}
			});
		}
		if(n>0)return new ResultBean<Object>("success",success);
		else return new ResultBean<Object>("fail",fail);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ResultBean<Bicycle_station> updateOneStation(Bicycle_station station) {
		List<Bicycle_pile> pilesNew=station.getPiles();
		List<Bicycle_pile> pilesOld=dao.getPiles(station.getStation_Id());
		dao.updateOneStation(station);
		dao.deletePiles(station.getStation_Id());
		if(pilesNew!=null){
			for(int j=0;j<pilesNew.size();j++){
				if(pilesNew.get(j)==null || pilesNew.get(j).getPile_Id()==null)continue;
				if(pilesOld.size()==0){
					dao.addOnePile(pilesNew.get(j));
					continue;
				}
				for(int i=0;i<pilesOld.size();i++){
					if(pilesOld.get(i).getPile_Id().equals(pilesNew.get(j).getPile_Id())){
						dao.updateOnePile(pilesNew.get(j));
						break;
					}
					if(i==pilesOld.size()-1){
						dao.addOnePile(pilesNew.get(j));
					}
				}
			}
			
		}
		station.setPiles(dao.getPiles(station.getStation_Id()));
		return new ResultBean<Bicycle_station>(station,"success",success);


	}

	@Override
	public ResultBean<Bicycle_station> getOneStation(Integer station_Id) {
		// TODO 自动生成的方法存根
		Bicycle_station station=dao.getOneStation(station_Id);
		if(station==null)return new ResultBean<>("error",fail);
		else  return new ResultBean<>(station,"success",success);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ResultBean<Object> deleteOneStation(Integer station_Id) {
		// TODO 自动生成的方法存根
		dao.deletePiles(station_Id);
		int n=dao.deleteOneStation(station_Id);


		if(n>0)return new ResultBean<Object>("success",success);
		else return new ResultBean<Object>("fail",fail);

	}

	@Override
	public ResultBean<Page<Bicycle_station>> getOnePage(Bicycle_station station, String targetPage) {

		Map<String, Object> map=new HashMap<String,Object>();
		Page<Bicycle_station> page=new Page<>();
		int targetpg=Integer.parseInt(targetPage);
		int start=(targetpg-1)*page.getPageSize();
		map.put("station", station);

		map.put("start", start);
		map.put("end", start+page.getPageSize());
		List<Bicycle_station> list=dao.getOnePage(map);
		trans(list);
		list.forEach(s->s.setPiles(dao.getPiles(s.getStation_Id())));
		page.setList(list);
		page.setTotal(dao.getCount(map));
		page.setPageCount((int)Math.ceil(page.getTotal()*1.0/page.getPageSize()));
		page.setCurrentPage(targetpg);

		return new ResultBean<Page<Bicycle_station>>(page,success);

	}
	private void trans(List<Bicycle_station> list){

		list.forEach(v->{
			if(v.getZxbj().equals("0")){
				v.setZxbj("正常");
			}else if(v.getZxbj().equals("1")){
				v.setZxbj("已注销");
			}
		});

	}

	@Override
	public ResultBean<Page<Bicycle_info>> getOnePageBicycle(Bicycle_info bicycle_info, String targetPage) {
		// TODO 自动生成的方法存根
		Map<String, Object> map=new HashMap<String,Object>();
		Page<Bicycle_info> page=new Page<>();
		int targetpg=Integer.parseInt(targetPage);
		int start=(targetpg-1)*page.getPageSize();
		map.put("bicycle_info", bicycle_info);

		map.put("start", start);
		map.put("end", start+page.getPageSize());

		List<Bicycle_info> list=dao.getOnePageBicycle(map);
		page.setList(list);
		page.setTotal(dao.getBicycleCount(map));
		page.setPageCount((int)Math.ceil(page.getTotal()*1.0/page.getPageSize()));
		page.setCurrentPage(targetpg);
		return new ResultBean<Page<Bicycle_info>>(page,success);
	}

}
