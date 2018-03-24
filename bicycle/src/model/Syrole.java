package model;
//角色表
public class Syrole {
	private Integer role_Id;
	private String	role_Name;
	private String	role_Describe;
	public Integer getRole_Id() {
		return role_Id;
	}
	public void setRole_Id(Integer role_Id) {
		this.role_Id = role_Id;
	}
	public String getRole_Name() {
		return role_Name;
	}
	public void setRole_Name(String role_Name) {
		this.role_Name = role_Name;
	}
	public String getRole_Describe() {
		return role_Describe;
	}
	public void setRole_Describe(String role_Describe) {
		this.role_Describe = role_Describe;
	}
	@Override
	public String toString() {
		return "Syrole [role_Id=" + role_Id + ", role_Name=" + role_Name + ", role_Describe=" + role_Describe + "]";
	}
	public Syrole(Integer role_Id, String role_Name, String role_Describe) {
		super();
		this.role_Id = role_Id;
		this.role_Name = role_Name;
		this.role_Describe = role_Describe;
	}
	public Syrole() {
		super();
	}
	
	
}
