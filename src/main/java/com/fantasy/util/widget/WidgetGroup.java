package com.fantasy.util.widget;

public class WidgetGroup {
	
	
	
	public static Widget group(Widget w){
		if(!w.getComponent().isEmpty()){
			for(Widget wi:w.getComponent()){
				if(wi.getComponent().isEmpty()){
					w.addParamete(wi);
				}else{
					Widget wt=group(wi);
					w.addParamete(wt);
				}
			}
		}
		return w;
	}
}
