package com.wikimerrykill.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.wikimerrykill.client.gin.DesktopInjectorWrapper;
import com.wikimerrykill.client.gin.InjectorWrapper;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Wmk implements EntryPoint {
	
	final private InjectorWrapper injectorWrapper = GWT.create(DesktopInjectorWrapper.class);
	
	public void onModuleLoad() {
		injectorWrapper.getInjector().getWmkApp().run();
	}
}
