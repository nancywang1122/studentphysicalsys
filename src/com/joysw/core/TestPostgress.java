package com.joysw.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestPostgress {

	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String filename = sdf.format(d) + ".tar";

		String dbname = "tomuse_develop";
		String username = "postgres";
		String dbpath = "C:/Program Files (x86)/PostgreSQL/9.2/bin/";
		String backuppath = "d:/" + filename;

		//new TestPostgress().backupDB(dbname, username, backuppath, dbpath);
		backuppath = "d:/20130111223229.tar";
		 new TestPostgress().restoreDB(dbname, username, backuppath, dbpath);
	}

	public boolean backupDB(String dbname, String username, String backuppath,
			String dbpath) {
		boolean flag = true;
		Runtime rt = Runtime.getRuntime();
		@SuppressWarnings("unused")
		Process process;
		StringBuffer cmdbuf = new StringBuffer();
		cmdbuf.append(dbpath);
		cmdbuf.append("pg_dump -U ");
		cmdbuf.append(username);
		cmdbuf.append(" -f ");
		cmdbuf.append(backuppath);
		cmdbuf.append(" -E utf8 ");
		cmdbuf.append(" -Ft ");
		cmdbuf.append(dbname);
		try {
			System.out.println(cmdbuf);
			rt.exec(cmdbuf.toString());
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	public boolean restoreDB(String dbname, String username, String backuppath,
			String dbpath) {

		boolean flag = true;
		Runtime rt = Runtime.getRuntime();
		@SuppressWarnings("unused")
		Process process;
		StringBuffer cmdTemp = new StringBuffer();
		cmdTemp.append(dbpath);
		cmdTemp.append("pg_restore -U ");
		cmdTemp.append(username);
		cmdTemp.append(" -c -d ");
		cmdTemp.append(" " + dbname + " ");
		cmdTemp.append(backuppath);
		try {
			process = rt.exec(cmdTemp.toString());
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
}
