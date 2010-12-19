package com.wikimerrykill.client.gin;

import com.google.gwt.inject.client.Ginjector;
import com.wikimerrykill.client.app.WmkApp;

//Interface that forces or "extending" injectors (who are interfaces)
//to return an WmkApp
public interface AppInjector extends Ginjector {
	WmkApp getWmkApp();
}
