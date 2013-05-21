package com.joysw.core;

public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="/sfa\\\\asfd/";
		str = str.replaceAll("\\\\", "/");
		System.out.println(str.split("/").length);
		
		String str222="里阿嫂分散asdfa三大法";
		System.out.println(str222.indexOf("分散3"));
	}

}
