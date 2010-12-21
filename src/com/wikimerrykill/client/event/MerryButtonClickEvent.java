package com.wikimerrykill.client.event;

import com.wikimerrykill.client.view.ContestantViewImpl;

public class MerryButtonClickEvent extends ContestantButtonClickEvent {

	public MerryButtonClickEvent(ContestantViewImpl contestantSource, boolean turnedOn) {
		super(contestantSource, turnedOn);
	}


}
