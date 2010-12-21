package com.wikimerrykill.client.event;

import com.wikimerrykill.client.view.ContestantViewImpl;

public class WikiButtonClickEvent extends ContestantButtonClickEvent {

	public WikiButtonClickEvent(ContestantViewImpl contestantSource, boolean turnedOn) {
		super(contestantSource, turnedOn);
	}


}
