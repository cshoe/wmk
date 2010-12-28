package com.wikimerrykill.client.event.handler;

import com.google.gwt.event.shared.EventHandler;
import com.wikimerrykill.client.event.GameOptionsChangeEvent;

public interface GameOptionsChangeHandler extends EventHandler {
	void onGameOptionsChange(GameOptionsChangeEvent e);
}
