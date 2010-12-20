package com.wikimerrykill.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.wikimerrykill.client.event.handler.KillButtonClickHandler;
import com.wikimerrykill.client.event.handler.MerryButtonClickHandler;
import com.wikimerrykill.client.event.handler.WikiButtonClickHandler;

public interface GameBoardView extends IsWidget {
	public ContestantView getContestantOne();
	public ContestantView getContestantTwo();
	public ContestantView getContestantThree();
	
	public interface Presenter extends KillButtonClickHandler, 
									MerryButtonClickHandler, WikiButtonClickHandler{
		
	}
	
	void setPresenter(Presenter presenter);
}
