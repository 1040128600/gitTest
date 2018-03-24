package model;
//车辆修理记录表
public class Repair_record {
	private Integer record_Id;
	private Integer bicycle_Id;
	private String repair_Type;
	private Integer repair_Part;
	private Double fee;
	private String repairer;
	private String repair_Date;
	private String remark;
	private Integer user_Id;
	private String operator_Time;
	@Override
	public String toString() {
		return "Repair_record [record_Id=" + record_Id + ", bicycle_Id=" + bicycle_Id + ", repair_Type=" + repair_Type
				+ ", repair_Part=" + repair_Part + ", fee=" + fee + ", repairer=" + repairer + ", repair_Date="
				+ repair_Date + ", remark=" + remark + ", user_Id=" + user_Id + ", operator_Time=" + operator_Time
				+ "]";
	}
	public Integer getRecord_Id() {
		return record_Id;
	}
	public void setRecord_Id(Integer record_Id) {
		this.record_Id = record_Id;
	}
	public Integer getBicycle_Id() {
		return bicycle_Id;
	}
	public void setBicycle_Id(Integer bicycle_Id) {
		this.bicycle_Id = bicycle_Id;
	}
	public String getRepair_Type() {
		return repair_Type;
	}
	public void setRepair_Type(String repair_Type) {
		this.repair_Type = repair_Type;
	}
	public Integer getRepair_Part() {
		return repair_Part;
	}
	public void setRepair_Part(Integer repair_Part) {
		this.repair_Part = repair_Part;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public String getRepairer() {
		return repairer;
	}
	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}
	public String getRepair_Date() {
		return repair_Date;
	}
	public void setRepair_Date(String repair_Date) {
		this.repair_Date = repair_Date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getOperator_Time() {
		return operator_Time;
	}
	public void setOperator_Time(String operator_Time) {
		this.operator_Time = operator_Time;
	}
	public Repair_record(Integer record_Id, Integer bicycle_Id, String repair_Type, Integer repair_Part, Double fee,
			String repairer, String repair_Date, String remark, Integer user_Id, String operator_Time) {
		super();
		this.record_Id = record_Id;
		this.bicycle_Id = bicycle_Id;
		this.repair_Type = repair_Type;
		this.repair_Part = repair_Part;
		this.fee = fee;
		this.repairer = repairer;
		this.repair_Date = repair_Date;
		this.remark = remark;
		this.user_Id = user_Id;
		this.operator_Time = operator_Time;
	}
	public Repair_record() {
		super();
	}
	
	
	
}
