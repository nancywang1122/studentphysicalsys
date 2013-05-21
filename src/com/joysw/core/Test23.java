package com.joysw.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("100|[1-9][0-9]|[1-9]");
		Matcher matcher = pattern.matcher("32");
		System.out.println(matcher.matches());
		
		
		Date date = new Date();
		System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(date));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 30);
		System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(cal
				.getTime()));
		
		try {
			System.out.println((new SimpleDateFormat("yyyy-MM-dd").parse("2013-01-31").getTime()-new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getTime())/(1000*60*60));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(new Date().getTime()+600240*60*1000)));
		
		
		
	}
}
