package com.wikimerrykill.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.wikimerrykill.client.event.handler.ContestantButtonClickHandler;
import com.wikimerrykill.client.event.handler.GameOptionsChangeHandler;

public interface GameBoardView extends IsWidget {
	public ContestantViewImpl getContestantOne();
	public ContestantViewImpl getContestantTwo();
	public ContestantViewImpl getContestantThree();
	
	public interface Presenter extends ContestantButtonClickHandler, GameOptionsChangeHandler {
		
	}
	
	void setPresenter(Presenter presenter);
}
