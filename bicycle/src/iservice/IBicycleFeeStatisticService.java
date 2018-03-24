package iservice;

import java.util.Map;

import model.BicycleStatistic;
import model.Bicycle_info;
import util.Page;
import util.ResultBean;

public interface IBicycleFeeStatisticService {
	public ResultBean<BicycleStatistic> getStatisticByMonth(String month);
	public ResultBean<BicycleStatistic> getStatisticByBicycleId(Integer bicycle_Id);
}
