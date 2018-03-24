package iservice;

import model.Bicycle_info;
import model.Bicycle_station;
import model.Vender;
import util.Page;
import util.ResultBean;

public interface IBicycleStationService {
	public ResultBean<Object> addOneStation(Bicycle_station station);
	public ResultBean<Bicycle_station>  updateOneStation(Bicycle_station station);
	public ResultBean<Bicycle_station> getOneStation(Integer station_Id);
	public ResultBean<Object> deleteOneStation(Integer station_Id);
	public ResultBean<Page<Bicycle_station>> getOnePage(Bicycle_station station,String targetPage);
	public ResultBean<Page<Bicycle_info>> getOnePageBicycle(Bicycle_info bicycle_info,String targetPage);
}
