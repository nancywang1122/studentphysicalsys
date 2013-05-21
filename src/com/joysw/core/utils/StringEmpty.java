package com.joysw.core.utils;

import java.util.ArrayList;
import java.util.List;

public class StringEmpty {

	public static boolean checkEmpty(String param) {
		if (param == null) {
			return true;
		}
		if ("".equals(param.trim())) {
			return true;
		}
		if ("null".equals(param.trim())) {
			return true;
		}
		return false;
	}

	public static String toString(String param) {
		if (param == null) {
			param = "";
		}
		if ("".equals(param.trim())) {
			param = "";
		}
		if ("null".equals(param.trim())) {
			param = "";
		}
		return param;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringEmpty.checkEmpty("ndull"));
		List<Object> params = new ArrayList<Object>();
		params.add("sdfds");
		System.out.println(params.toArray().length);
		
	}
}
