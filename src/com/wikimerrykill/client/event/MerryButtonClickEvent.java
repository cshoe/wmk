package com.wikimerrykill.client.event;

import com.wikimerrykill.client.view.ContestantView;

public class MerryButtonClickEvent extends ContestantButtonClickEvent {

	public MerryButtonClickEvent(ContestantView contestantSource, boolean turnedOn) {
		super(contestantSource, turnedOn);
	}


}
