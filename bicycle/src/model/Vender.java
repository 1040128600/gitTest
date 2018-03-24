package model;
//供应商表
public class Vender {
private Integer vender_Id;
private String	vender_Code;
private String	vender_Type;
private String	vender_Name;
private String	address;
private String	telphone;
private String	contacts;
private String	product_License;
private String	bussiness_Registration_No;
private Double  registered_Capital;
private Integer	user_Id;
private String	create_Time;
private String	zxbj;
private String	remark;
@Override
public String toString() {
	return "Vender [vender_Id=" + vender_Id + ", vender_Code=" + vender_Code + ", vender_Type=" + vender_Type
			+ ", vender_Name=" + vender_Name + ", address=" + address + ", telphone=" + telphone + ", contacts="
			+ contacts + ", product_License=" + product_License + ", bussiness_Registration_No="
			+ bussiness_Registration_No + ", registered_Capital=" + registered_Capital + ", user_Id=" + user_Id
			+ ", create_Time=" + create_Time + ", zxbj=" + zxbj + ", remark=" + remark + "]";
}
public Integer getVender_Id() {
	return vender_Id;
}
public void setVender_Id(Integer vender_Id) {
	this.vender_Id = vender_Id;
}
public String getVender_Code() {
	return vender_Code;
}
public void setVender_Code(String vender_Code) {
	this.vender_Code = vender_Code;
}
public String getVender_Type() {
	return vender_Type;
}
public void setVender_Type(String vender_Type) {
	this.vender_Type = vender_Type;
}
public String getVender_Name() {
	return vender_Name;
}
public void setVender_Name(String vender_Name) {
	this.vender_Name = vender_Name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTelphone() {
	return telphone;
}
public void setTelphone(String telphone) {
	this.telphone = telphone;
}
public String getContacts() {
	return contacts;
}
public void setContacts(String contacts) {
	this.contacts = contacts;
}
public String getProduct_License() {
	return product_License;
}
public void setProduct_License(String product_License) {
	this.product_License = product_License;
}
public String getBussiness_Registration_No() {
	return bussiness_Registration_No;
}
public void setBussiness_Registration_No(String bussiness_Registration_No) {
	this.bussiness_Registration_No = bussiness_Registration_No;
}
public Double getRegistered_Capital() {
	return registered_Capital;
}
public void setRegistered_Capital(Double registered_Capital) {
	this.registered_Capital = registered_Capital;
}
public Integer getUser_Id() {
	return user_Id;
}
public void setUser_Id(Integer user_Id) {
	this.user_Id = user_Id;
}
public String getCreate_Time() {
	return create_Time;
}
public void setCreate_Time(String create_Time) {
	this.create_Time = create_Time;
}
public String getZxbj() {
	return zxbj;
}
public void setZxbj(String zxbj) {
	this.zxbj = zxbj;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Vender(Integer vender_Id, String vender_Code, String vender_Type, String vender_Name, String address,
		String telphone, String contacts, String product_License, String bussiness_Registration_No,
		Double registered_Capital, Integer user_Id, String create_Time, String zxbj, String remark) {
	super();
	this.vender_Id = vender_Id;
	this.vender_Code = vender_Code;
	this.vender_Type = vender_Type;
	this.vender_Name = vender_Name;
	this.address = address;
	this.telphone = telphone;
	this.contacts = contacts;
	this.product_License = product_License;
	this.bussiness_Registration_No = bussiness_Registration_No;
	this.registered_Capital = registered_Capital;
	this.user_Id = user_Id;
	this.create_Time = create_Time;
	this.zxbj = zxbj;
	this.remark = remark;
}
public Vender() {
	super();
}

}
