package model;

import java.io.Serializable;

public class BicycleStatistic implements Serializable {

	private static final long serialVersionUID = 1L;
	private int bicycleNum;
	
	private int rentTimes;
	private int repairTimes;
	private double avgRentTime;
	private int sumRentTime;
	private double avgRepairFee;
	private double sumRepairFee;
	private double avgIncomeFee;
	private double sumIncomeFee;
	
	private int deployTimes;
	private int useTime;
	
	
	
	public int getUseTime() {
		return useTime;
	}


	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}


	public int getBicycleNum() {
		return bicycleNum;
	}


	public void setBicycleNum(int bicycleNum) {
		this.bicycleNum = bicycleNum;
	}


	public int getRentTimes() {
		return rentTimes;
	}


	public void setRentTimes(int rentTimes) {
		this.rentTimes = rentTimes;
	}








	public int getRepairTimes() {
		return repairTimes;
	}


	public void setRepairTimes(int repairTimes) {
		this.repairTimes = repairTimes;
	}


	public double getAvgRentTime() {
		return avgRentTime;
	}


	public void setAvgRentTime(double avgRentTime) {
		this.avgRentTime = avgRentTime;
	}


	public int getSumRentTime() {
		return sumRentTime;
	}


	public void setSumRentTime(int sumRentTime) {
		this.sumRentTime = sumRentTime;
	}


	public double getAvgRepairFee() {
		return avgRepairFee;
	}


	public void setAvgRepairFee(double avgRepairFee) {
		this.avgRepairFee = avgRepairFee;
	}


	public double getSumRepairFee() {
		return sumRepairFee;
	}


	public void setSumRepairFee(double sumRepairFee) {
		this.sumRepairFee = sumRepairFee;
	}


	public double getAvgIncomeFee() {
		return avgIncomeFee;
	}


	public void setAvgIncomeFee(double avgIncomeFee) {
		this.avgIncomeFee = avgIncomeFee;
	}


	public double getSumIncomeFee() {
		return sumIncomeFee;
	}


	public void setSumIncomeFee(double sumIncomeFee) {
		this.sumIncomeFee = sumIncomeFee;
	}


	public int getDeployTimes() {
		return deployTimes;
	}


	public void setDeployTimes(int deployTimes) {
		this.deployTimes = deployTimes;
	}


	@Override
	public String toString() {
		return "BicycleStatistic [bicycleNum=" + bicycleNum + ", rentTimes=" + rentTimes + ", repaireTimes="
				+ repairTimes + ", avgRentTime=" + avgRentTime + ", sumRentTime=" + sumRentTime + ", avgRepairFee="
				+ avgRepairFee + ", sumRepairFee=" + sumRepairFee + ", avgIncomeFee=" + avgIncomeFee + ", sumIncomeFee="
				+ sumIncomeFee + ", deployTimes=" + deployTimes + ", useTime=" + useTime + "]";
	}



	
	
	
}
