package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import iservice.IRentReturnService;
import model.Bicycle_pile;
import model.Bicycle_station;
import model.Syuser;
import util.ResultBean;
import static util.ResultBean.*;

@Controller
@RequestMapping("/rentAndReturn")
public class RentReturnController {
	@Autowired
	private IRentReturnService service;
	
	@RequestMapping(value="/rent",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String rentBicycle(String card_Code,int bicycle_Id,int pile_Id,HttpSession session){
		Integer user_Id=((Syuser)session.getAttribute("loginUser")).getUser_Id();
		 ResultBean<Object> rb=service.rentBicycle(card_Code, bicycle_Id, pile_Id,user_Id);
		if(rb.getState()==success)return JSON.toJSONString("借车成功");
		else return JSON.toJSONString(rb.getMsg());
		
	}
	
	@RequestMapping(value="/return",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String returnBicycle(String card_Code,int pile_Id,HttpSession session){
		
		Integer user_Id=((Syuser)session.getAttribute("loginUser")).getUser_Id();
		 ResultBean<Object> rb=service.returnBicycle(card_Code, pile_Id,user_Id);
		if(rb.getState()==success)return JSON.toJSONString("还车成功");
		else return JSON.toJSONString(rb.getMsg());
		
		
	}
	
}
