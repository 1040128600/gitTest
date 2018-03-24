package util;
import java.util.ArrayList;
import java.util.List;
public class Page<T> {
	private int total;//总条数
	private int pageSize=8;//每页条数
	private int pageCount; //页数
	private int currentPage=1;//当前第几页
	
	private List<T> list=new ArrayList<T>();
	public Page(){}
	
	public Page(int total, int pageCount, int pageSize, int currentPage) {
		super();
		this.total = total;
		this.pageCount = pageCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [total=" + total + ", pageSize=" + pageSize + ", pageCount=" + pageCount + ", currentPage="
				+ currentPage + ", list=" + list + "]";
	}


	
}

