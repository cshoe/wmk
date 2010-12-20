package com.wikimerrykill.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.wikimerrykill.client.event.handler.KillButtonClickHandler;

public class KillButtonClickEvent extends GwtEvent<KillButtonClickHandler> {

	public static Type<KillButtonClickHandler> TYPE 
										= new Type<KillButtonClickHandler>(); 
	
	@Override
	protected void dispatch(KillButtonClickHandler handler) {
		handler.onKillButtonClick();
	}

	@Override
	public Type<KillButtonClickHandler> getAssociatedType() {
		return TYPE;
	}

}
