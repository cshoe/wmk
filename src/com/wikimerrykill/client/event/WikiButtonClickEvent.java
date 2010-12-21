package com.wikimerrykill.client.event;

import com.wikimerrykill.client.view.ContestantView;

public class WikiButtonClickEvent extends ContestantButtonClickEvent {

	public WikiButtonClickEvent(ContestantView contestantSource, boolean turnedOn) {
		super(contestantSource, turnedOn);
	}


}
