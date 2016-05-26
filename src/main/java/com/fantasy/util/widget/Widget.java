package com.fantasy.util.widget;

import java.util.List;

public class Widget {
	
//	public static void getWidget(String tag, String attribute, String paramete,List<Widget> list) {
//		Widget widget=new Widget();
//		widget.setTag(tag);
//		widget.setAttribute(attribute);
//		widget.setParamete(paramete);
//		
//		list.add(widget);
//	}
	
	public Widget(String tag,String attribute,String paramete){
		this.tag=tag;
		this.attribute=attribute;
		this.paramete=paramete;
	}

	String tag;
	String attribute;
	String paramete;
	List<Widget> list;
	
	public List<Widget> getList() {
		return list;
	}
	public void setList(List<Widget> list) {
		this.list = list;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	public void setParamete(String paramete) {
		this.paramete = paramete;
	}
	
	public String getTag() {
		return tag;
	}
	public String getAttribute() {
		return attribute;
	}
	public String getParamete() {
		return paramete;
	}
	
	public Widget addParamete(Widget w){
		paramete=paramete+w.getComponent();
		return this;
	}
	
//	public Widget addComponent(Widget w){
//		paramete=paramete+w.getComponent();
//		return this;
//	}
	
	public String getComponent(){
		String temp="";
		if(null==attribute||attribute.equals("")){
			temp="<"+tag+">"+paramete+"</"+tag+">";
		}else{
			temp="<"+tag+" "+attribute+">"+paramete+"</"+tag+">";
		}
		return temp;
	}
	
}
