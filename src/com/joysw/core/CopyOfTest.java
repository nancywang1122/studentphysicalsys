package com.joysw.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.joysw.bean.sysmenubean.SysMenuBean;

public class CopyOfTest {

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
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("total", "toatal");
		map2.put("rows", "[{'sdf':'23'}]");
		System.out.println(JSONArray.fromObject(map2).toString());
		/*IdentityHashMap<String, Object> map = new IdentityHashMap<String, Object>();
		for (int i = 0; i < 3; i++) {
			map.put(new String("id"), "" + i + 1);
			map2.putAll(map);
		}*/
		
		List<SysMenuBean> parentMenuBeanList = new ArrayList<SysMenuBean>();
		SysMenuBean sys = new SysMenuBean();
		sys.setMenuId(new Integer(1));
		parentMenuBeanList.add(sys);

		// System.out.println(map.size());

		// System.out.println(JSONObject.fromObject(map).toString());
		 System.out.println(JSONArray.fromObject(parentMenuBeanList).toString());
		// System.out.println(JSONSerializer.toJSON(map).toString());
		/*
		 * Test t = new Test(); boolean flag = true; if(t.get()){
		 * System.out.println(flag); }
		 */

		/*IdentityHashMap<String, Object> map3 = new IdentityHashMap<String, Object>();
		map3.put(new String("id"), 1);
		map3.put(new String("id"), 2);
		for (Entry<String, Object> entry : map3.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}*/
		 System.out.println("1,2,1,".split(",").length);
	}

}
