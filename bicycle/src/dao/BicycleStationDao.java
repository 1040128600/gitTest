package dao;

import java.util.List;
import java.util.Map;

import model.Bicycle_info;
import model.Bicycle_pile;
import model.Bicycle_station;



public interface BicycleStationDao {
	public int addOneStation(Bicycle_station station);
	public int updateOneStation(Bicycle_station station);
	public Bicycle_station getOneStation(Integer station_Id);
	public int deleteOneStation(Integer station_Id);
	public int getCount(Map<String,Object> map);
	public List<Bicycle_station> getOnePage(Map<String,Object> map);
	
	public int addOnePile(Bicycle_pile pile);
	public List<Bicycle_pile> getPiles(Integer station_Id);
	public Bicycle_pile getOnePile(Integer pile_Id);
	public int updateOnePile(Bicycle_pile pile);
	public int deleteOnePile(Integer pile_Id);
	public int deletePiles(Integer station_Id);
	
	public int getBicycleCount(Map<String,Object> map);
	public List<Bicycle_info> getOnePageBicycle(Map<String,Object> map);
}
