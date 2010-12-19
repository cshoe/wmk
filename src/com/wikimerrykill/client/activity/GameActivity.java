package com.wikimerrykill.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.wikimerrykill.client.view.GameView;

public class GameActivity extends AbstractActivity {
	private GameView view;
	
	@Inject
	public GameActivity(GameView view) {
		this.view = view;
	}
	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view.asWidget());
	}

}
