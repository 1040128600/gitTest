package model;

import org.omg.PortableInterceptor.INACTIVE;

//车辆购入明细表
public class Bicycle_order_detall {
	private Integer detail_Id;
	private Integer catagory_Id;
	private Integer order_Id;
	private Integer bicycle_Id;
	private String create_Date;
	private String batch_No;
	private Double price;
	private String remark;
	public Bicycle_order_detall(Integer detail_Id, Integer catagory_Id, Integer order_Id, Integer bicycle_Id,
			String create_Date, String batch_No, Double price, String remark) {
		super();
		this.detail_Id = detail_Id;
		this.catagory_Id = catagory_Id;
		this.order_Id = order_Id;
		this.bicycle_Id = bicycle_Id;
		this.create_Date = create_Date;
		this.batch_No = batch_No;
		this.price = price;
		this.remark = remark;
	}
	public Bicycle_order_detall() {
		super();
	}
	public Integer getDetail_Id() {
		return detail_Id;
	}
	public void setDetail_Id(Integer detail_Id) {
		this.detail_Id = detail_Id;
	}
	public Integer getCatagory_Id() {
		return catagory_Id;
	}
	public void setCatagory_Id(Integer catagory_Id) {
		this.catagory_Id = catagory_Id;
	}
	public Integer getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(Integer order_Id) {
		this.order_Id = order_Id;
	}
	public Integer getBicycle_Id() {
		return bicycle_Id;
	}
	public void setBicycle_Id(Integer bicycle_Id) {
		this.bicycle_Id = bicycle_Id;
	}
	public String getCreate_Date() {
		return create_Date;
	}
	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}
	public String getBatch_No() {
		return batch_No;
	}
	public void setBatch_No(String batch_No) {
		this.batch_No = batch_No;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Bicycle_order_detall [detail_Id=" + detail_Id + ", catagory_Id=" + catagory_Id + ", order_Id="
				+ order_Id + ", bicycle_Id=" + bicycle_Id + ", create_Date=" + create_Date + ", batch_No=" + batch_No
				+ ", price=" + price + ", remark=" + remark + "]";
	}
	
	
	
	
}
