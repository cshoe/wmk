package com.wikimerrykill.client.event;

import com.wikimerrykill.client.view.ContestantView;

public class KillButtonClickEvent extends ContestantButtonClickEvent {

	public KillButtonClickEvent(ContestantView contestantSource, boolean turnedOn) {
		super(contestantSource, turnedOn);
	}
}
