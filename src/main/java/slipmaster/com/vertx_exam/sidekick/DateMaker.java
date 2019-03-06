package slipmaster.com.vertx_exam.sidekick;


import java.util.Calendar;
import java.util.Date;

public class DateMaker {

	
	/***
	 * Get a fix date using calendar
	 * @param year
	 * @param month
	 * @param day
	 * @return fixed date
	 */
	public static Date dateHelper(int year , int month , int day)
	{
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(year, month , day);
		date =  cal.getTime();
		
		return date;
	}
}
