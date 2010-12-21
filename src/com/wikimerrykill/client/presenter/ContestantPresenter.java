package com.wikimerrykill.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.wikimerrykill.client.event.KillButtonClickEvent;
import com.wikimerrykill.client.event.MerryButtonClickEvent;
import com.wikimerrykill.client.event.WikiButtonClickEvent;
import com.wikimerrykill.client.view.ContestantView;
import com.wikimerrykill.client.view.ContestantView.Presenter;

public class ContestantPresenter implements Presenter {
	
	private EventBus eventBus;
	
	@Inject
	public ContestantPresenter(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	public void onKillChange(ContestantView c, boolean turnedOn) {
		KillButtonClickEvent k = new KillButtonClickEvent(c, turnedOn);
		eventBus.fireEvent(k);
	}

	public void onMerryChange(ContestantView c, boolean turnedOn) {
		MerryButtonClickEvent m = new MerryButtonClickEvent(c, turnedOn);
		eventBus.fireEvent(m);
	}

	public void onWikiChange(ContestantView c, boolean turnedOn) {
		WikiButtonClickEvent w = new WikiButtonClickEvent(c, turnedOn);
		eventBus.fireEvent(w);
	}

}
