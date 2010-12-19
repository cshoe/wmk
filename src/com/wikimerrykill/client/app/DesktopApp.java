package com.wikimerrykill.client.app;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;
import com.wikimerrykill.client.activity.WmkActivityMapper;
import com.wikimerrykill.client.place.GamePlace;
import com.wikimerrykill.client.place.WmkPlaceHistoryMapper;
import com.wikimerrykill.client.view.Shell;

public class DesktopApp extends WmkApp {
	private final Shell shell;
	private final EventBus eventBus;
	private final PlaceController placeController;
	private final WmkActivityMapper wmkActivityMapper;
	private final WmkPlaceHistoryMapper wmkPlaceHistoryMapper;
	
	private Place defaultPlace = new GamePlace();
	
	@Inject
	public DesktopApp(Shell shell, EventBus eventBus, PlaceController placeController,
			WmkActivityMapper wmkActivityMapper, WmkPlaceHistoryMapper wmkPlaceHistroyMapper) {
		this.shell = shell;
		this.eventBus = eventBus;
		this.placeController = placeController;
		this.wmkActivityMapper = wmkActivityMapper;
		this.wmkPlaceHistoryMapper = wmkPlaceHistroyMapper;
	}
	
	@Override
	public void run() {
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			public void onUncaughtException(Throwable e) {
				Window.alert("Hey, something went wrong: " + e.getMessage());
				// we could log this if we were using logging...
				
			}
		});
		
		/* Add handlers, setup activities */
		CachingActivityMapper cached = new CachingActivityMapper(wmkActivityMapper);
		final ActivityManager mainActivityManager = new ActivityManager(cached, eventBus);
		
		mainActivityManager.setDisplay(shell.getContent());
		
		// Start PlaceHistoryHandler with our PlaceHistoryMapper
        WmkPlaceHistoryMapper historyMapper= wmkPlaceHistoryMapper;
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);
        
        RootLayoutPanel.get().add(shell);
	    
	    historyHandler.handleCurrentHistory();
	}
}