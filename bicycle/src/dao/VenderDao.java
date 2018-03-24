package dao;

import java.util.List;
import java.util.Map;

import model.Vender;
import util.Page;
import util.ResultBean;

public interface VenderDao {
	public int addOneVender(Vender vender);
	public int updateOneVender(Vender vender);
	public Vender getOneVender(String vender_id);
	public int deleteOneVender(String vender_id);
	public int getCount(Map<String,Object> map);
	public List<Vender> getOnePage(Map<String,Object> map);
}
