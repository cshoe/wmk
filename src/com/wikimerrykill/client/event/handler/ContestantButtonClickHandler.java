package com.wikimerrykill.client.event.handler;

import com.google.gwt.event.shared.EventHandler;
import com.wikimerrykill.client.event.ContestantButtonClickEvent;

public interface ContestantButtonClickHandler extends EventHandler {
	void onContestantButtonClick(ContestantButtonClickEvent e);
}
