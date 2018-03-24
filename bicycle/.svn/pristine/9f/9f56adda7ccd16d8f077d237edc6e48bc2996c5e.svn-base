package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import iservice.IBicycleFeeStatisticService;
import model.BicycleStatistic;
import util.ResultBean;

@Controller
@RequestMapping("/BicycleFeeStatistic")
public class BicycleFeeStatisticController {
	@Autowired
	private IBicycleFeeStatisticService service;
	
	@RequestMapping(value="/getStatisticByMonth",produces="text/json;charset=utf-8")
	@ResponseBody
	public String getStatisticByMonth(String year,String month){
		month=year+"-"+month;
		ResultBean<BicycleStatistic> rb= service.getStatisticByMonth( month);
		
		
		return JSON.toJSONString(rb.getResult());
	}
	@RequestMapping(value="/getStatisticByBicycleId",produces="text/json;charset=utf-8")
	@ResponseBody
	public String getStatisticByBicycleId(int bicycle_Id){
		ResultBean<BicycleStatistic> rb=service.getStatisticByBicycleId(bicycle_Id);
		return JSON.toJSONString(rb.getResult());
	}
}
