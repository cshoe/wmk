package com.wikimerrykill.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface ContestantView extends IsWidget {
	
	public void setWikiButtonEnabled(boolean isEnabled);
	public void setMerryButtonEnabled(boolean isEnabled);
	public void setKillButtonEnabled(boolean isEnabled);
	
	public void setWikiButtonValue(boolean toWiki);
	public void setMerryButtonValue(boolean toMerry);
	public void setKillButtonValue(boolean toKill);

	public interface Presenter {
		void onWikiChange(ContestantView c, boolean turnedOn);
		void onMerryChange(ContestantView c, boolean turnedOn);
		void onKillChange(ContestantView c, boolean turnedOn); 
	}
	
	void setPresenter(Presenter presenter);
}
