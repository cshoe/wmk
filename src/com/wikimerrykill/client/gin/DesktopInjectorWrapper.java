package com.wikimerrykill.client.gin;

import com.google.gwt.core.client.GWT;

public class DesktopInjectorWrapper implements InjectorWrapper {

	public AppInjector getInjector() {
		return GWT.create(DesktopInjector.class);
	}

}
