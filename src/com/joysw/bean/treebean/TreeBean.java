package com.joysw.bean.treebean;

import java.util.List;

public class TreeBean {

	private String id;
	private String text;
	private String state;
	private List<TreeBean> children;
	private boolean checked;
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public List<TreeBean> getChildren() {
		return children;
	}
	public void setChildren(List<TreeBean> children) {
		this.children = children;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
