package com.fantasy.util.widget;

public class WidgetGroup {
	
	
	
	public static void group(Widget w){
		//System.out.println(w.getHtml());
		if(!w.getComponent().isEmpty()){
			for(Widget wi:w.getComponent()){
				System.out.println(wi.getHtml());
				if(!wi.getComponent().isEmpty()){
					group(wi);
				}
				
				w.addParamete(wi);
			}
			
		}
	}
}
