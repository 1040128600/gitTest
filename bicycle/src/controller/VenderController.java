package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import iservice.IVenderService;
import model.Syuser;
import model.Vender;
import util.Page;
import util.ResultBean;
import static util.ResultBean.*;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value="/vender")
public class VenderController {
	@Autowired
	private IVenderService venderService;
	
	
	@RequestMapping(value="/addVender" )//,produces="text/json;charset=UTF-8"
	public String addVender(Vender vender,HttpServletRequest request,HttpSession session){
		int id= ((Syuser)(session.getAttribute("loginUser"))).getUser_Id();
			vender.setUser_Id(id);
		ResultBean<Object> rb =venderService.addOneVender(vender);
		if(rb.getState()==success){
			request.setAttribute("returnMsg", "添加成功");
			return "/vender/addVender.jsp";
		}
		
		else{
			request.setAttribute("returnMsg", "添加失败");
			request.setAttribute("vender0", vender);
			return "/vender/addVender.jsp";
		}
		
	}
	@RequestMapping(value="/getOnePage",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String getOnePage(Vender vender,String targetPage,HttpSession session){
		System.out.println(vender+targetPage);
		if(session.getAttribute("loginUser")==null)session.setAttribute("loginUser", new Syuser(11));
		ResultBean<Page<Vender>> rb=venderService.getOnePage(vender,targetPage);
		return JSON.toJSONString(rb.getResult());
		
	}
	@RequestMapping(value="/getOneVender")
	public String getOneVender(String vender_Id,String readonly,HttpServletRequest request){
		ResultBean<Vender> rb=venderService.getOneVender(vender_Id);
		if(rb.getState()==success){
			request.setAttribute("vender0", rb.getResult());
			if("1".equals(readonly)){return "/vender/viewVender.jsp";}
			return "/vender/updateVender.jsp";
		}else{
			request.setAttribute("returnMsg", "获取失败");
		
			return "/vender/venderManager.jsp";
		}
	
		
	}
	@RequestMapping("/updateOneVender")
	public String updateOneVender(Vender vender,HttpServletRequest request){
		System.out.println();
		System.out.println(vender);
		ResultBean<Object> rb=venderService.updateOneVender(vender);
		request.setAttribute("vender0",vender);
		if(rb.getState()==success){
			request.setAttribute("returnMsg", "修改成功");
			
		}else{
			request.setAttribute("returnMsg", "修改失败");

		}
		return "/vender/updateVender.jsp";
		
	}
	@RequestMapping("/deleteOneVender")
	public String deleteOneVender(String vender_Id,HttpServletRequest request){
		ResultBean<Object> rb=venderService.deleteOneVender(vender_Id);
		if(rb.getState()==success){
			request.setAttribute("returnMsg", "注销成功");
		}else{
			request.setAttribute("returnMsg", "注销失败");
		}
		return "/vender/venderManager.jsp";
	}
	
	
	

}
