package model;
//业务流水表
public class Bicycle_deal {
	private Integer deal_Id;
	private String create_Time;
	private String deal_Name;
	private String deal_Type;
	private Integer record_Id;
	private Integer card_Id;
	private String is_Fee;
	private Double chg_Money;
	private Integer fee_Type;
	private Integer bicycle_Id;
	private Integer pile_Id;
	private Integer user_Id;
	public Integer getDeal_Id() {
		return deal_Id;
	}
	public void setDeal_Id(Integer deal_Id) {
		this.deal_Id = deal_Id;
	}
	public String getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(String create_Time) {
		this.create_Time = create_Time;
	}
	public String getDeal_Name() {
		return deal_Name;
	}
	public void setDeal_Name(String deal_Name) {
		this.deal_Name = deal_Name;
	}
	public String getDeal_Type() {
		return deal_Type;
	}
	public void setDeal_Type(String deal_Type) {
		this.deal_Type = deal_Type;
	}
	public Integer getRecord_Id() {
		return record_Id;
	}
	public void setRecord_Id(Integer record_Id) {
		this.record_Id = record_Id;
	}
	public Integer getCard_Id() {
		return card_Id;
	}
	public void setCard_Id(Integer card_Id) {
		this.card_Id = card_Id;
	}
	public String getIs_Fee() {
		return is_Fee;
	}
	public void setIs_Fee(String is_Fee) {
		this.is_Fee = is_Fee;
	}
	public Double getChg_Money() {
		return chg_Money;
	}
	public void setChg_Money(Double chg_Money) {
		this.chg_Money = chg_Money;
	}
	public Integer getFee_Type() {
		return fee_Type;
	}
	public void setFee_Type(Integer fee_Type) {
		this.fee_Type = fee_Type;
	}
	public Integer getBicycle_Id() {
		return bicycle_Id;
	}
	public void setBicycle_Id(Integer bicycle_Id) {
		this.bicycle_Id = bicycle_Id;
	}
	public Integer getPile_Id() {
		return pile_Id;
	}
	public void setPile_Id(Integer pile_Id) {
		this.pile_Id = pile_Id;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	@Override
	public String toString() {
		return "Bicycle_deal [deal_Id=" + deal_Id + ", create_Time=" + create_Time + ", deal_Name=" + deal_Name
				+ ", deal_Type=" + deal_Type + ", record_Id=" + record_Id + ", card_Id=" + card_Id + ", is_Fee="
				+ is_Fee + ", chg_Money=" + chg_Money + ", fee_Type=" + fee_Type + ", bicycle_Id=" + bicycle_Id
				+ ", pile_Id=" + pile_Id + ", user_Id=" + user_Id + "]";
	}
	public Bicycle_deal(Integer deal_Id, String create_Time, String deal_Name, String deal_Type, Integer record_Id,
			Integer card_Id, String is_Fee, Double chg_Money, Integer fee_Type, Integer bicycle_Id, Integer pile_Id,
			Integer user_Id) {
		super();
		this.deal_Id = deal_Id;
		this.create_Time = create_Time;
		this.deal_Name = deal_Name;
		this.deal_Type = deal_Type;
		this.record_Id = record_Id;
		this.card_Id = card_Id;
		this.is_Fee = is_Fee;
		this.chg_Money = chg_Money;
		this.fee_Type = fee_Type;
		this.bicycle_Id = bicycle_Id;
		this.pile_Id = pile_Id;
		this.user_Id = user_Id;
	}
	public Bicycle_deal() {
		super();
	}
	
	
	
	
}
