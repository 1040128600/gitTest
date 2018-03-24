package util;

public class ResultBean<T> {
	public static final int  success=1;
	public static final int fail=-1;

	private T  result;
	private String msg="";
	private int state=-1;
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public ResultBean(T result, String msg, int state) {
		super();
		this.result = result;
		this.msg = msg;
		this.state = state;
	}
	public ResultBean(T result, int state) {
		super();
		this.result = result;
		this.state = state;
	}
	public ResultBean(String msg, int state) {
		super();
		this.msg = msg;
		this.state = state;
	}
	public ResultBean(int state) {
		super();
		this.state = state;
	}
	@Override
	public String toString() {
		return "ResultBean [result=" + result + ", msg=" + msg + ", state=" + state + "]";
	}
	
}
