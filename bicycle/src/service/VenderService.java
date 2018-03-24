package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.VenderDao;
import iservice.IVenderService;

import model.Vender;
import util.Page;
import util.ResultBean;
import static util.ResultBean.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class VenderService implements IVenderService {
	@Autowired
	private VenderDao venderDao;
	@Override
	public ResultBean<Vender> getOneVender(String vender_Id) {
		// TODO 自动生成的方法存根
		Vender vender= venderDao.getOneVender(vender_Id);
		if(vender==null){
			return new ResultBean<Vender>("error",fail);
		}else{
			return new ResultBean<Vender>(vender,success);
		}
		
	}

	@Override
	public ResultBean<Object> deleteOneVender(String vender_Id) {
		// TODO 自动生成的方法存根
		int n=venderDao.deleteOneVender(vender_Id);
		if(n==1)return new ResultBean<Object>("success",success);
		else return new ResultBean<Object>("error",fail);
		
	}

	@Override
	public ResultBean<Page<Vender>> getOnePage(Vender vender,String targetPage) {
		// TODO 自动生成的方法存根
		
		Map<String, Object> map=new HashMap<String,Object>();
		Page<Vender> page=new Page();
		int targetpg=Integer.parseInt(targetPage);
		int start=(targetpg-1)*page.getPageSize();
		map.put("vender", vender);
		
		map.put("start", start);
		map.put("end", start+page.getPageSize());
		List<Vender> list=venderDao.getOnePage(map);
		trans(list);
		page.setList(list);
		page.setTotal(venderDao.getCount(map));
		page.setPageCount((int)Math.ceil(page.getTotal()*1.0/page.getPageSize()));
		page.setCurrentPage(targetpg);
		
		return new ResultBean<Page<Vender>>(page,success);
	}
	private void trans(List<Vender> list){
		
		list.forEach(v->{
			if(v.getZxbj().equals("0")){
				v.setZxbj("正常");
			}else if(v.getZxbj().equals("1")){
				v.setZxbj("已注销");
			}
			if(v.getVender_Type().equals("1")){
				v.setVender_Type("生产商");
			}else if(v.getVender_Type().equals("2")){
				v.setVender_Type("供应商");
			}
			
				});
		
	}

	@Override
	@Transactional
	public ResultBean<Object> addOneVender(Vender vender) {
		// TODO 自动生成的方法存根
		int n=venderDao.addOneVender(vender);
		if(n==1)  return new ResultBean<Object>("增加成功",success);
		else return new ResultBean<Object>("增加失败",fail);
		
	}

	@Override
	public ResultBean<Object> updateOneVender(Vender vender) {
		// TODO 自动生成的方法存根
		int n=venderDao.updateOneVender(vender);
		if(n==1)  return new ResultBean<Object>("修改成功",success);
		else return new ResultBean<Object>("修改失败",fail);
	
	}
		
}
