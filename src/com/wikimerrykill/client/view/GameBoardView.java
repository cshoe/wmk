package com.wikimerrykill.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.wikimerrykill.client.event.handler.ContestantButtonClickHandler;
import com.wikimerrykill.client.event.handler.GameOptionsChangeHandler;

public interface GameBoardView extends IsWidget {
	public ContestantView getContestantOne();
	public ContestantView getContestantTwo();
	public ContestantView getContestantThree();
	
	public void setContestantOne(ContestantViewImpl c);
	public void setContestantTwo(ContestantViewImpl c);
	public void setContestantThree(ContestantViewImpl c);
	
	public void refreshContestants(ContestantViewImpl one, ContestantViewImpl two, ContestantViewImpl three);
	
	public interface Presenter extends ContestantButtonClickHandler, GameOptionsChangeHandler {
		
	}
	
	void setPresenter(Presenter presenter);
}
