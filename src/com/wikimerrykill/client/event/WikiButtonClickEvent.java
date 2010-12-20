package com.wikimerrykill.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.wikimerrykill.client.event.handler.WikiButtonClickHandler;

public class WikiButtonClickEvent extends GwtEvent<WikiButtonClickHandler> {

	public static Type<WikiButtonClickHandler> TYPE 
										= new Type<WikiButtonClickHandler>();

	@Override
	protected void dispatch(WikiButtonClickHandler handler) {
		handler.onWikiButtonClick();
	}

	@Override
	public Type<WikiButtonClickHandler> getAssociatedType() {
		return TYPE;
	}

}
