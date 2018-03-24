package service;

import dao.BicycleFeeStatisticDao;
import iservice.IBicycleFeeStatisticService;
import model.BicycleStatistic;
import model.Bicycle_info;
import util.Page;
import util.ResultBean;
import static util.ResultBean.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BicycleFeeStatisticService implements IBicycleFeeStatisticService {
	@Autowired
	private BicycleFeeStatisticDao dao;
	@Override
	public ResultBean<BicycleStatistic> getStatisticByMonth(String month) {
		// TODO 自动生成的方法存根
		BicycleStatistic b =new BicycleStatistic();
		b.setBicycleNum(dao.getBicycleNumByMonth(month));
		b.setRentTimes(dao.getRentTimesByMonth(month));
		b.setRepairTimes(dao.getRepairTimesByMonth(month));
		b.setSumRentTime(dao.getRentTimeByMonth(month));
		b.setSumIncomeFee(dao.getIncomeByMonth(month));
		b.setSumRepairFee(dao.getRepairFeeByMonth(month));
		if(b.getRentTimes()==0){
			
		}else{
			b.setAvgRentTime(1.0*b.getSumRentTime()/b.getRentTimes());
			b.setAvgIncomeFee(b.getSumIncomeFee()/b.getRentTimes());
		}
		if(b.getRepairTimes()==0){
			b.setAvgRepairFee(0);
		}else{
			b.setAvgRepairFee(b.getSumRepairFee()/b.getRepairTimes());
		}
		return new ResultBean<BicycleStatistic>(b,success);
	}

	@Override
	public ResultBean<BicycleStatistic> getStatisticByBicycleId(Integer bicycle_Id) {
		// TODO 自动生成的方法存根
		BicycleStatistic b =new BicycleStatistic();
		b.setUseTime(dao.getBicycleUseTime(bicycle_Id));
		b.setRentTimes(dao.getBicycleRentTimes(bicycle_Id));
		b.setRepairTimes(dao.getBicycleRepairTimes(bicycle_Id));
		b.setSumRentTime(dao.getBicycleRentTime(bicycle_Id));
		b.setSumIncomeFee(dao.getBicycleIncome(bicycle_Id));
		b.setSumRepairFee(dao.getBicycleRepairFee(bicycle_Id));
		if(b.getRentTimes()==0){
			b.setAvgRentTime(0);
			b.setAvgIncomeFee(0);
		}else{
			b.setAvgRentTime(1.0*b.getSumRentTime()/b.getRentTimes());
			b.setAvgIncomeFee(b.getSumIncomeFee()/b.getRentTimes());
		}
		if(b.getRepairTimes()==0){
			b.setSumRepairFee(0);
		}else{
			b.setAvgRepairFee(b.getSumRepairFee()/b.getRepairTimes());
		}
		b.setDeployTimes(dao.getBicycleDeployTimes(bicycle_Id));
		return new ResultBean<BicycleStatistic>(b,success);
	}



}
