package com.wikimerrykill.client.event;

import com.wikimerrykill.client.view.ContestantViewImpl;

public class KillButtonClickEvent extends ContestantButtonClickEvent {

	public KillButtonClickEvent(ContestantViewImpl contestantSource, boolean turnedOn) {
		super(contestantSource, turnedOn);
	}
}
