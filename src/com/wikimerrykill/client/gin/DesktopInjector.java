package com.wikimerrykill.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.wikimerrykill.client.app.DesktopApp;

@GinModules(value = {AppInjectorModule.class})
public interface DesktopInjector extends AppInjector {
	DesktopApp getWmkApp();
}
