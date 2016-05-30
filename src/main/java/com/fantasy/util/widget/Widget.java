package com.fantasy.util.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Widget {
	
	public Widget(String tag,String attribute,String paramete){
		this.tag=tag;
		this.attribute=attribute;
		this.paramete=paramete;
	}

	String tag;
	String attribute;
	String paramete;
	List<Widget> list=new ArrayList<>();
	
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
		paramete=paramete+w.getHtml();
		return this;
	}
	
	public List<Widget> getComponent(){
		return list;
	}

	public Widget setComponent(Widget w){
		list.add(w);
		return this;
	}
	
	public String getHtml(){
		String temp="";
		if(null==attribute||attribute.equals("")){
			temp="<"+tag+">"+paramete+"</"+tag+">";
		}else{
			temp="<"+tag+" "+attribute+">"+paramete+"</"+tag+">";
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Widget wSpan=new Widget("span","class=\"caret\"","");
		Widget wA=new Widget("a","href=\"#\"","HOME");
		Widget wLi=new Widget("li","class=\"active\"","");
		
		wLi.setComponent(wA.setComponent(wSpan));
		
		Widget w=WidgetGroup.group(wLi);
	}
}
