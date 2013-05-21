package com.joysw.core;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class DateTime {
	public static void main(String[] args) {
		Calendar c_begin = new GregorianCalendar();
		Calendar c_end = new GregorianCalendar();
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] weeks = dfs.getWeekdays();
		String[] weekss = dfs.getShortWeekdays();
		c_begin.set(2013, 4, 1); // Calendar的月从0-11，所以4月是3.
		c_end.set(2013, 5, 1); // Calendar的月从0-11，所以5月是4.
		int count = 1;
		c_end.add(Calendar.DAY_OF_YEAR, 0); // 结束日期下滚一天是为了包含最后一天
		Map map = new HashMap();
		while (c_begin.before(c_end)) {
			System.out.println("第" + count + "周  日期："
					+ new java.sql.Date(c_begin.getTime().getTime()) + ","
					+ weeks[c_begin.get(Calendar.DAY_OF_WEEK)] + ","
					+ c_begin.get(Calendar.DAY_OF_MONTH));
			if (c_begin.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				count++;
			}
			c_begin.add(Calendar.DAY_OF_YEAR, 1);
		}
		/*System.out.println("第" + count + "周  日期："
				+ new java.sql.Date(c_begin.getTime().getTime()) + ","
				+ weeks[c_begin.get(Calendar.DAY_OF_WEEK)] + ","
				+ c_begin.get(Calendar.DAY_OF_MONTH));*/
		
	}
}
