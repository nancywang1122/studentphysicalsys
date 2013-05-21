package com.joysw.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.joysw.bean.treebean.TreeBean;

public class Test {

	public static JSONArray toJson(Map<String, Object> map) {
		return JSONArray.fromObject(map);
	}

	public boolean get() {
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		System.out.println(101/60);
		List<TreeBean> list = new ArrayList<TreeBean>();
		TreeBean t = new TreeBean();
		t.setId("1");
		t.setText("323");
		list.add(t);
		t = new TreeBean();
		t.setId("1");
		t.setText("323");
		list.add(t);
		System.out.println(JSONArray.fromObject(list));
	}
}
