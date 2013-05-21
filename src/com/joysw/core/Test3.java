package com.joysw.core;

public class Test3 {

	public static String arrayFunc(String[] args) {
		String str="";
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
				str+=args[i];
			}
		}
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] argss = "3,4,5".split(",");
		System.out.println(Test3.arrayFunc(argss));
	}
}
