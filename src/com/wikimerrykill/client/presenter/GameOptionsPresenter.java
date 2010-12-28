package com.wikimerrykill.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasDirectionalText;
import com.wikimerrykill.client.event.GameOptionsChangeEvent;
import com.wikimerrykill.client.view.GameOptionsView;

public class GameOptionsPresenter implements GameOptionsView.Presenter {

	private EventBus eventBus;
	
	public GameOptionsPresenter(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	public void onFemaleClicked(boolean femaleOn, boolean maleOn) {
		GameOptionsChangeEvent g = new GameOptionsChangeEvent(maleOn, femaleOn);
		eventBus.fireEventFromSource(g, false);
	}

	public void onMaleClicked(boolean maleOn, boolean femaleOn) {
		GameOptionsChangeEvent g = new GameOptionsChangeEvent(maleOn, femaleOn);
		eventBus.fireEventFromSource(g, false);
	}

	public void onFemaleClicked(boolean femaleOn, boolean maleOn, HasDirectionalText l) {
		GameOptionsChangeEvent g = new GameOptionsChangeEvent(maleOn, femaleOn);
		eventBus.fireEventFromSource(g, false);
		
		if (femaleOn) {
			l.setText("Female on");
		} else {
			l.setText("Female off");
		}
	}

	public void onMaleClicked(boolean maleOn, boolean femaleOn, HasDirectionalText l) {
		GameOptionsChangeEvent g = new GameOptionsChangeEvent(maleOn, femaleOn);
		eventBus.fireEventFromSource(g, false);
		
		if (maleOn) {
			l.setText("Male on");
		} else {
			l.setText("Male off");
		}
	}

}
