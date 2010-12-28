package com.wikimerrykill.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.wikimerrykill.client.event.handler.GameOptionsChangeHandler;

public class GameOptionsChangeEvent extends GwtEvent<GameOptionsChangeHandler> {
	
	public static Type<GameOptionsChangeHandler> TYPE = 
							new Type<GameOptionsChangeHandler>();
	
	private boolean maleOn;
	private boolean femaleOn;
	
	public GameOptionsChangeEvent(boolean maleOn, boolean femaleOn) {
		this.maleOn = maleOn;
		this.femaleOn = femaleOn;
	}
	
	public boolean getMaleOn() {
		return maleOn;
	}
	
	public boolean getFemaleOn() {
		return femaleOn;
	}
	
	@Override
	protected void dispatch(GameOptionsChangeHandler handler) {
		handler.onGameOptionsChange(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<GameOptionsChangeHandler> getAssociatedType() {
		return TYPE;
	}

}
