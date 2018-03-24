package controller;

import static util.ResultBean.success;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import iservice.IBicycleStationService;
import model.Bicycle_info;
import model.Bicycle_pile;
import model.Bicycle_station;
import model.Syuser;

import util.Page;
import util.ResultBean;
import util.StringUtil;

@Controller
@RequestMapping("/station")
public class BicycleStationController {
	@Autowired
	private IBicycleStationService service;

	@RequestMapping(value="/addStation" )//,produces="text/json;charset=UTF-8"
	public String addStation(Bicycle_station station,HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException{
		System.out.println();
		System.out.println(station);
	
				
	
		ResultBean<Object> rb =service.addOneStation(station);

		if(rb.getState()==success){
			request.setAttribute("returnMsg", "添加成功");

		}

		else{
			request.setAttribute("returnMsg", "添加失败");
			request.setAttribute("station0", station);

		}
		return "/station/addStation.jsp";

	}
	@RequestMapping(value="/getOnePage",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String getOnePage(Bicycle_station station,String targetPage,HttpSession session){
		System.out.println(station+targetPage);
		//---假登录
		session.setAttribute("loginUser", new Syuser(11));


		ResultBean<Page<Bicycle_station>> rb=service.getOnePage(station,targetPage);
		System.out.println("-----------"+rb.getResult());

		return JSON.toJSONString(rb.getResult());

	}
	@RequestMapping(value="/getOneStation")
	public String getOneStation(String station_Id,String readonly,HttpServletRequest request){
		ResultBean<Bicycle_station> rb=service.getOneStation(Integer.parseInt(station_Id));
		if(rb.getState()==success){
			System.out.println("-----------"+rb.getResult());
			System.out.println(rb.getResult().getPiles());
			request.setAttribute("station0", rb.getResult());
			if( rb.getResult().getPiles()==null){
				request.setAttribute("pileNum", 0);
			}else{
				request.setAttribute("pileNum", rb.getResult().getPiles().size());
			}
			if("1".equals(readonly)){return "/station/viewStation.jsp";}
			return "/station/updateStation.jsp";
		}else{
			request.setAttribute("returnMsg", "获取失败");

			return "/station/stationManager.jsp";
		}


	}
	@RequestMapping("/updateOneStation")
	public String updateOneStation(Bicycle_station station,HttpServletRequest request){
		System.out.println();
		System.out.println(station);
		ResultBean<Bicycle_station> rb=service.updateOneStation(station);
		/*if(station.getPiles()!=null){
			for(int i=0;i<station.getPiles().size();i++)
				if(station.getPiles().get(i)==null || station.getPiles().get(i).getPile_Id()==null){
					station.getPiles().remove(i);
					i--;
				}
			}*/
		station=rb.getResult();
		request.setAttribute("pileNum", station.getPiles().size());
		request.setAttribute("station0",station);
		if(rb.getState()==success){
			request.setAttribute("returnMsg", "修改成功");

		}else{
			request.setAttribute("returnMsg", "修改失败");

		}
		return "/station/updateStation.jsp";

	}
	@RequestMapping("/deleteOneStation")
	public String deleteOneStation(String station_Id,HttpServletRequest request){
		ResultBean<Object> rb=service.deleteOneStation(Integer.parseInt(station_Id));
		if(rb.getState()==success){
			request.setAttribute("returnMsg", "注销成功");
		}else{
			request.setAttribute("returnMsg", "注销失败");
		}
		return "/station/stationManager.jsp";
	}

	@RequestMapping(value="getOnePageBicycle",produces="text/json;charset=utf-8")
	@ResponseBody
	public String getOnePageBicycle(Bicycle_info bicycle_info,String targetPage){
		ResultBean<Page<Bicycle_info>> rb=service.getOnePageBicycle(bicycle_info, targetPage);
		return JSON.toJSONString(rb.getResult());
	}

}
