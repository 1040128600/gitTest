package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.RentReturnDao;
import iservice.IRentReturnService;
import model.Bicycle_deal;
import model.Bicycle_info;
import model.Bicycle_pile;
import model.Bicycle_record;
import model.Card;
import model.Card_record;
import util.ResultBean;
import util.StringUtil;

import static util.ResultBean.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
@Service
public class RentReturnService implements IRentReturnService {
	@Autowired
	private RentReturnDao dao;
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ResultBean<Object> rentBicycle(String card_Code, Integer bicycle_Id, Integer pile_Id,Integer user_Id) {
		// TODO 自动生成的方法存根
		
		Card card=dao.getOneCard(card_Code);
		if(card==null)return new ResultBean<Object>("卡号不存在",fail);
		Integer card_Id=card.getCard_Id();
		String date=StringUtil.getDate("yyyy-MM-dd HH:mm:ss");
		Bicycle_info bicycle_info=dao.getOneBicycle(bicycle_Id);
		if(bicycle_info==null)return new ResultBean<Object>("桩上没有车",fail);
		if(!bicycle_info.getStatus().equals("3"))return new ResultBean<Object>("车辆不在桩",fail);
		
		if(card.getWallet_Money()+card.getFrozen_Money()<200) return new ResultBean<Object>("余额不足",fail);
		if(card.getStatus()==2)return new ResultBean<Object>("卡已被锁定",fail);
		if(dao.ifRented(card_Id)!=null)return new ResultBean<Object>("还有未还车辆",fail);
		
		//可以借车了
		bicycle_info.setStatus("2");
		bicycle_info.setCard_Id(card_Id);
		bicycle_info.setPile_Id(0);
		dao.updateBicycle_info(bicycle_info);
		Bicycle_pile bicycle_pile=new Bicycle_pile();
		bicycle_pile.setStatus("2");
		bicycle_pile.setPile_Id(pile_Id);
		bicycle_pile.setBicycle_Id("0");
		dao.updatePile(bicycle_pile);
		
		String isFee="0";
		double cha=0;
		int Fee_Type=0;
		if(card.getFrozen_Money()<200.0){
			isFee="1";
			Fee_Type=3;
			double wallet=card.getWallet_Money();
			cha=200.0-card.getFrozen_Money();
			wallet-=cha;
			card.setFrozen_Money(200.0);
			card.setWallet_Money(wallet);
			dao.updateCard(card);
			Card_record card_record=new Card_record();//卡费用流水
			card_record.setCard_Id(card.getCard_Id());
			card_record.setFee_Type(3);
			card_record.setChg_Monthly_Money(0.0);
			card_record.setChg_Wallet_Money(-cha);
			card_record.setChg_Frozen_Money(cha);
			card_record.setCreate_Time(date);
			card_record.setUser_Id(user_Id);
			card_record.setRemark(" ");
			card_record.setZxbj(0);
			dao.addCard_record(card_record);
		}
		Bicycle_record bicycle_record=new Bicycle_record();//增加租还记录
		bicycle_record.setBicycle_Id(bicycle_Id);
		bicycle_record.setCard_Id(card_Id);
		bicycle_record.setRent_Time(date);
		bicycle_record.setRent_Pile_Id(pile_Id);
		bicycle_record.setRemark(" ");
		dao.addBicycle_record(bicycle_record);
		
		Bicycle_deal bicycle_deal=new Bicycle_deal();//车辆业务流水
		bicycle_deal.setCreate_Time(date);
		bicycle_deal.setDeal_Name("租车");
		bicycle_deal.setDeal_Type("2");
		bicycle_deal.setRecord_Id(bicycle_record.getRecord_Id());
		bicycle_deal.setCard_Id(card_Id);
		bicycle_deal.setIs_Fee(isFee);
		bicycle_deal.setChg_Money(cha);
		bicycle_deal.setFee_Type(Fee_Type);
		bicycle_deal.setBicycle_Id(bicycle_Id);
		bicycle_deal.setPile_Id(pile_Id);
		bicycle_deal.setUser_Id(user_Id);
		dao.addBicycle_deal(bicycle_deal);
		
		return new ResultBean<Object>("success",success);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ResultBean<Object> returnBicycle(String card_Code, Integer pile_Id, Integer user_Id) {
		// TODO 自动生成的方法存根
		Card card=dao.getOneCard(card_Code);
		if(card==null)return new ResultBean<Object>("卡号不存在",fail);

		Integer card_Id=card.getCard_Id();
		String date=StringUtil.getDate("yyyy-MM-dd HH:mm:ss");
	
		Bicycle_record bicycle_record =  dao.ifRented(card_Id);
		if(bicycle_record==null)return new ResultBean<Object>("没有未还车辆",fail);
		Bicycle_info bicycle_info=dao.getOneBicycle(bicycle_record.getBicycle_Id());
		Bicycle_pile pile=dao.getOnePile(pile_Id);
		if(!pile.getStatus().equals("2"))return new ResultBean<Object>("桩上已有车或车桩已损坏",fail);
		
		//---计算时间差
		String returnTime=date;
		int hours=0;
		try {
		 hours=StringUtil.getHours(bicycle_record.getRent_Time(),returnTime);
		 System.err.println("renttime:"+bicycle_record.getRent_Time()+" returnTime"+returnTime+" hours:"+hours);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		String isFee="1";
		int Fee_Type=1;
		double fee=0;
		if(hours==1){
			fee=0;
			isFee="0";
			Fee_Type=0;
		}else if(hours==2){
			fee=1;
		}else if(hours==3){
			fee=2;
		}else {
			fee=2+(hours-3)*3;
		}
		
		if(card.getWallet_Money()<fee){
			System.err.println("wallet:"+card.getWallet_Money()+"--fee:"+fee);
			 return new ResultBean<Object>("余额不足,无法还车",fail);
		}
		
		if(fee!=0){

	
			card.setWallet_Money(card.getWallet_Money()-fee);
			dao.updateCard(card);
			Card_record card_record=new Card_record();//卡费用流水
			card_record.setCard_Id(card.getCard_Id());
			card_record.setFee_Type(3);
			card_record.setChg_Monthly_Money(0.0);
			card_record.setChg_Wallet_Money(-fee);
			card_record.setChg_Frozen_Money(0.0);
			card_record.setCreate_Time(date);
			card_record.setUser_Id(user_Id);
			card_record.setRemark(" ");
			card_record.setZxbj(0);
			dao.addCard_record(card_record);
		}
		
		bicycle_record.setReturn_Pile_Id(pile_Id);
		bicycle_record.setReturn_Time(returnTime);
		bicycle_record.setMoney(fee);
		bicycle_record.setRemark(" ");
		dao.updateBicycle_record(bicycle_record);
		

		
		pile.setStatus("1");
		pile.setBicycle_Id(bicycle_info.getBicycle_Id()+"");
		dao.updatePile(pile);
		
		Bicycle_deal bicycle_deal=new Bicycle_deal();//车辆业务流水
		bicycle_deal.setCreate_Time(date);
		bicycle_deal.setDeal_Name("还入");
		bicycle_deal.setDeal_Type("3");
		bicycle_deal.setRecord_Id(bicycle_record.getRecord_Id());
		bicycle_deal.setCard_Id(card_Id);
		bicycle_deal.setIs_Fee(isFee);
		bicycle_deal.setChg_Money(fee);
		bicycle_deal.setFee_Type(Fee_Type);
		bicycle_deal.setBicycle_Id(bicycle_info.getBicycle_Id());
		bicycle_deal.setPile_Id(pile_Id);
		bicycle_deal.setUser_Id(user_Id);
		dao.addBicycle_deal(bicycle_deal);
		
		bicycle_info.setStatus("3");
		bicycle_info.setCard_Id(0);
		bicycle_info.setPile_Id(pile_Id);
		dao.updateBicycle_info(bicycle_info);
		
		
		 return new ResultBean<Object>("sucess",success);
	}



}
