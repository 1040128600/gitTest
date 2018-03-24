package dao;



import model.Bicycle_deal;
import model.Bicycle_info;
import model.Bicycle_pile;
import model.Bicycle_record;
import model.Card;
import model.Card_record;

public interface RentReturnDao {
	public Bicycle_info getOneBicycle(Integer bicycle_Id);
	public int updateBicycle_info(Bicycle_info bicycle_info);
	public Bicycle_pile getOnePile(Integer pile_Id);
	public int updatePile(Bicycle_pile bicycle_pile);
	public Card getOneCard(String card_Code );
	public int updateCard(Card card);
	public int addBicycle_record(Bicycle_record bicycle_record);
	public int updateBicycle_record(Bicycle_record bicycle_record);
	public int addBicycle_deal(Bicycle_deal bicycle_deal);
	public int addCard_record(Card_record card_record);
	public Bicycle_record ifRented(Integer card_Id);
	
	
}
