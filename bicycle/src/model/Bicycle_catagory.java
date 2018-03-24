package model;
//车辆——车辆类型表
public class Bicycle_catagory {
	private Integer catagory_Id;
	private String catagory_Name;
	private String frame_Type;
	private Double weight;
	private Double height;
	private Double length;
	private String ring_Type;
	private String basket;
	private String backseat;
	private String bicycle_Seat;
	private String handbrake;
	private String remark;
	private Integer user_Id;
	private String operator_Time;
	public Integer getCatagory_Id() {
		return catagory_Id;
	}
	public void setCatagory_Id(Integer catagory_Id) {
		this.catagory_Id = catagory_Id;
	}
	public String getCatagory_Name() {
		return catagory_Name;
	}
	public void setCatagory_Name(String catagory_Name) {
		this.catagory_Name = catagory_Name;
	}
	public String getFrame_Type() {
		return frame_Type;
	}
	public void setFrame_Type(String frame_Type) {
		this.frame_Type = frame_Type;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public String getRing_Type() {
		return ring_Type;
	}
	public void setRing_Type(String ring_Type) {
		this.ring_Type = ring_Type;
	}
	public String getBasket() {
		return basket;
	}
	public void setBasket(String basket) {
		this.basket = basket;
	}
	public String getBackseat() {
		return backseat;
	}
	public void setBackseat(String backseat) {
		this.backseat = backseat;
	}
	public String getBicycle_Seat() {
		return bicycle_Seat;
	}
	public void setBicycle_Seat(String bicycle_Seat) {
		this.bicycle_Seat = bicycle_Seat;
	}
	public String getHandbrake() {
		return handbrake;
	}
	public void setHandbrake(String handbrake) {
		this.handbrake = handbrake;
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
	@Override
	public String toString() {
		return "Bicycle_catagory [catagory_Id=" + catagory_Id + ", catagory_Name=" + catagory_Name + ", frame_Type="
				+ frame_Type + ", weight=" + weight + ", height=" + height + ", length=" + length + ", ring_Type="
				+ ring_Type + ", basket=" + basket + ", backseat=" + backseat + ", bicycle_Seat=" + bicycle_Seat
				+ ", handbrake=" + handbrake + ", remark=" + remark + ", user_Id=" + user_Id + ", operator_Time="
				+ operator_Time + "]";
	}
	public Bicycle_catagory(Integer catagory_Id, String catagory_Name, String frame_Type, Double weight, Double height,
			Double length, String ring_Type, String basket, String backseat, String bicycle_Seat, String handbrake,
			String remark, Integer user_Id, String operator_Time) {
		super();
		this.catagory_Id = catagory_Id;
		this.catagory_Name = catagory_Name;
		this.frame_Type = frame_Type;
		this.weight = weight;
		this.height = height;
		this.length = length;
		this.ring_Type = ring_Type;
		this.basket = basket;
		this.backseat = backseat;
		this.bicycle_Seat = bicycle_Seat;
		this.handbrake = handbrake;
		this.remark = remark;
		this.user_Id = user_Id;
		this.operator_Time = operator_Time;
	}
	public Bicycle_catagory() {
		super();
	}
	
	
	

}
