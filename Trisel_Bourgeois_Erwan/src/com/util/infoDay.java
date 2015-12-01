package com.util;

import java.util.Calendar;
import java.util.Date;

public class infoDay {
	
	private Date date ;
	private int yearDay;
	private int monthDay;
	private int day;
	
	public infoDay(Date date) {
		
		super();
		this.date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		yearDay = cal.get(Calendar.YEAR);
	    monthDay = cal.get(Calendar.MONTH);
	    day = cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getYearDay() {
		return yearDay;
	}

	public int getMonthDay() {
		return monthDay;
	}

	public int getDay() {
		return day;
	}

}
