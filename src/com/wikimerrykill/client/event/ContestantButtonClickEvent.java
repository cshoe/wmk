package com.wikimerrykill.client.event;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.wikimerrykill.client.event.handler.ContestantButtonClickHandler;
import com.wikimerrykill.client.view.ContestantViewImpl;

public class ContestantButtonClickEvent extends
		GwtEvent<ContestantButtonClickHandler> {
	
	public static Type<ContestantButtonClickHandler> TYPE 
										= new Type<ContestantButtonClickHandler>();
	
	private ContestantViewImpl contestantSource;
	private boolean turnedOn;
	
	public ContestantButtonClickEvent(ContestantViewImpl contestantSource, boolean turnedOn) {
		this.contestantSource = contestantSource;
		this.turnedOn = turnedOn;
	}
	
	public static void register(EventBus eventBus, ContestantButtonClickHandler handler) {
		eventBus.addHandler(TYPE, handler);
	}
	
	@Override
	protected void dispatch(ContestantButtonClickHandler handler) {
		handler.onContestantButtonClick(this);
	}

	@Override
	public Type<ContestantButtonClickHandler> getAssociatedType() {
		return TYPE;
	}
	
	public ContestantViewImpl getContestantSource() {
		return contestantSource;
	}
	
	public boolean isOn() {
		return turnedOn;
	}

}
