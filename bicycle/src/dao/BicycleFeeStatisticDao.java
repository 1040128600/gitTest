package dao;

import java.util.Map;

public interface BicycleFeeStatisticDao {
	public int getBicycleNumByMonth(String month);
	public int getRentTimesByMonth(String month);
	public int getRentTimeByMonth(String month);
	public int getRepairTimesByMonth(String month);
	public double getIncomeByMonth(String month);
	public double getRepairFeeByMonth(String month);
	
	public int getBicycleUseTime(Integer bicycle_Id);
	public int getBicycleRentTimes(Integer bicycle_Id);
	public int getBicycleRepairTimes(Integer bicycle_Id);
	public int getBicycleDeployTimes(Integer bicycle_Id);
	public int getBicycleRentTime(Integer bicycle_Id);
	public double getBicycleIncome(Integer bicycle_Id);
	public double getBicycleRepairFee(Integer bicycle_Id);
}
