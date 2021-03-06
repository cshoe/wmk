package com.wikimerrykill.client.gin;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Singleton;
import com.wikimerrykill.client.gin.provider.PlaceControllerProvider;

public class AppInjectorModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		// we can also use a Provider to configure our injections
		bind(PlaceController.class).toProvider(PlaceControllerProvider.class).in(Singleton.class);
		
		// Hey, notice that we are configuring every thing that is ultimately injected?
		// take a look at DesktopApp.java, We ask Gin to inject DesktopShell and MainActivityMapper
		// (we ask gin by declaring these parameters in the constructor and then annotating with @Inject
		// Well if we don't define what exactly to inject, Gin will just call GWT.create(WhatEverClass.class)
		// So in certain cases that is all we need!

	}

}
