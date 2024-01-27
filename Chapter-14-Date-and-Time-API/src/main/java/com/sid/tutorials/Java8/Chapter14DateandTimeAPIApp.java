/**
 * 
 */
package com.sid.tutorials.Java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Lenovo
 *
 */
public class Chapter14DateandTimeAPIApp {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		int dd = date.getDayOfMonth();
		System.out.println(dd);
		int mm = date.getMonthValue();
		System.out.println(mm);
		int yyyy = date.getYear();
		System.out.println(yyyy);
		LocalTime time = LocalTime.now();
		int hh = time.getHour();
		System.out.println(hh);
		int mi = time.getMinute();
		System.out.println(mi);
		int ss = time.getSecond();
		System.out.println(ss);
		int no = time.getNano();
		System.out.println(no);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date date2 = formatter.parse(dd + "-" + mm + "-" + yyyy + " " + hh + ":" + mi + ":" + ss);
		System.out.println("Date2 is : " + date2);
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Date Time is: " + dateTime);
		dd = dateTime.getDayOfMonth();
		System.out.println(dd);
		mm = dateTime.getMonthValue();
		System.out.println(mm);
		yyyy = dateTime.getYear();
		System.out.println(yyyy);
		hh = dateTime.getHour();
		System.out.println(hh);
		mi = dateTime.getMinute();
		System.out.println(mi);
		ss = dateTime.getSecond();
		System.out.println(ss);
		no = dateTime.getNano();
		System.out.println("Nano: " + no);
		date2 = formatter.parse(dd + "-" + mm + "-" + yyyy + " " + hh + ":" + mi + ":" + ss);
		System.out.println("Date is: " + date2);
		LocalDate bod = LocalDate.of(1987, Month.APRIL, 25);
		Period period = Period.between(bod, date);
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
		ZoneId systemDefault = ZoneId.systemDefault();
		System.out.println(systemDefault);
	}

}
