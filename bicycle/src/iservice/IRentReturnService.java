package iservice;

import util.ResultBean;

public interface IRentReturnService {
	public ResultBean<Object> rentBicycle(String card_Code,Integer bicycle_Id,Integer pile_Id ,Integer user_Id);
	public ResultBean<Object> returnBicycle(String card_Code,Integer pile_Id ,Integer user_Id);
}
