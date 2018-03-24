package util;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringUtil {
	public static void transToSpace(Object obj) throws IllegalArgumentException, IllegalAccessException{
		Field[] fs=obj.getClass().getDeclaredFields();
		
		for(Field f:fs){
			f.setAccessible(true);
			if(("".equals(f.get(obj)))){
				f.set(obj, " ");
			}
		}
	}
	public static String getDate(String dateFormate){
		Date date=Calendar.getInstance().getTime();
		SimpleDateFormat f=new SimpleDateFormat(dateFormate);
		return f.format(date);
	}
	public static int getHours(String rent_Time, String returnTime) throws ParseException {
		// TODO 自动生成的方法存根
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//如2016-08-10 20:40  
		long from = simpleFormat.parse(rent_Time).getTime();  
		long to = simpleFormat.parse(returnTime).getTime();
		int hours = (int)Math.ceil((double)(((to - from)/(1000.0 * 60 * 60))));
		
		return hours;
	}
	public static void main(String[] args) throws ParseException {
		System.out.println((0.0/0.0));
	}
}
