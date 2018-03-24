package model;
//用户
public class Syuser {
	private Integer user_Id;
	private Integer	role_Id;
	private String	login_Name;
	private String	username;	
	private String	password;
	private Integer	active_Flag;
	private String	zxbj;
	private String	office_Phone;
	private String	mobile_Phone;
	private String	email;
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public Integer getRole_Id() {
		return role_Id;
	}
	public void setRole_Id(Integer role_Id) {
		this.role_Id = role_Id;
	}
	public String getLogin_Name() {
		return login_Name;
	}
	public void setLogin_Name(String login_Name) {
		this.login_Name = login_Name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getActive_Flag() {
		return active_Flag;
	}
	public void setActive_Flag(Integer active_Flag) {
		this.active_Flag = active_Flag;
	}
	public String getZxbj() {
		return zxbj;
	}
	public void setZxbj(String zxbj) {
		this.zxbj = zxbj;
	}
	public String getOffice_Phone() {
		return office_Phone;
	}
	public void setOffice_Phone(String office_Phone) {
		this.office_Phone = office_Phone;
	}
	public String getMobile_Phone() {
		return mobile_Phone;
	}
	public void setMobile_Phone(String mobile_Phone) {
		this.mobile_Phone = mobile_Phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Syuser [user_Id=" + user_Id + ", role_Id=" + role_Id + ", login_Name=" + login_Name + ", username="
				+ username + ", password=" + password + ", active_Flag=" + active_Flag + ", zxbj=" + zxbj
				+ ", office_Phone=" + office_Phone + ", mobile_Phone=" + mobile_Phone + ", email=" + email + "]";
	}
	public Syuser(Integer user_Id, Integer role_Id, String login_Name, String username, String password,
			Integer active_Flag, String zxbj, String office_Phone, String mobile_Phone, String email) {
		super();
		this.user_Id = user_Id;
		this.role_Id = role_Id;
		this.login_Name = login_Name;
		this.username = username;
		this.password = password;
		this.active_Flag = active_Flag;
		this.zxbj = zxbj;
		this.office_Phone = office_Phone;
		this.mobile_Phone = mobile_Phone;
		this.email = email;
	}
	public Syuser() {
		super();
	}
	public Syuser(Integer user_Id) {
		super();
		this.user_Id = user_Id;
	}
	
	
	
	
	
}
