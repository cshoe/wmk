package com.wikimerrykill.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.wikimerrykill.client.event.handler.MerryButtonClickHandler;

public class MerryButtonClickEvent extends GwtEvent<MerryButtonClickHandler> {

	public static Type<MerryButtonClickHandler> TYPE 
										= new Type<MerryButtonClickHandler>();
	
	@Override
	protected void dispatch(MerryButtonClickHandler handler) {
		handler.onMerryButtonClick();
	}

	@Override
	public Type<MerryButtonClickHandler> getAssociatedType() {
		return TYPE;
	}

}
