package com.wikimerrykill.client.presenter;

import java.util.ArrayList;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.wikimerrykill.client.event.ContestantButtonClickEvent;
import com.wikimerrykill.client.event.KillButtonClickEvent;
import com.wikimerrykill.client.event.MerryButtonClickEvent;
import com.wikimerrykill.client.event.WikiButtonClickEvent;
import com.wikimerrykill.client.view.ContestantView;
import com.wikimerrykill.client.view.ContestantViewImpl;
import com.wikimerrykill.client.view.GameBoardView.Presenter;

public class GameBoardPresenter implements Presenter {
	private ContestantViewImpl contestantOne;
	private ContestantViewImpl contestantTwo;
	private ContestantViewImpl contestantThree;
	private EventBus eventBus;
	
	@Inject
	public GameBoardPresenter(ContestantViewImpl one, ContestantViewImpl two, ContestantViewImpl three, EventBus eventBus) {
		this.contestantOne = one;
		this.contestantTwo = two;
		this.contestantThree = three;
		this.eventBus = eventBus;
		bind();
		
	}
	
	private void bind() {
		eventBus.addHandler(ContestantButtonClickEvent.TYPE, this);
	}

	//Handles button clicks from contestant views
	public void onContestantButtonClick(ContestantButtonClickEvent e) {
		if (e instanceof WikiButtonClickEvent) {
			onWikiButtonClick(e);
		} else if (e instanceof MerryButtonClickEvent) {
			onMerryButtonClick(e);
		} else if (e instanceof KillButtonClickEvent) {
			onKillButtonClick(e);
		}
		
	}
	
	private void onWikiButtonClick(ContestantButtonClickEvent e) {
		ContestantView clicked = e.getContestantSource();
		ArrayList<ContestantView> unclicked = 
						getUnClickedContestantViews(clicked);
		if (e.isOn()) {
			for (ContestantView c : unclicked) {
				c.setWikiButtonValue(false);
			}
			clicked.setKillButtonValue(false);
			clicked.setMerryButtonValue(false);
		}
	}

	private void onMerryButtonClick(ContestantButtonClickEvent e) {
		ContestantView clicked = e.getContestantSource();
		ArrayList<ContestantView> unclicked = 
						getUnClickedContestantViews(clicked);
		if (e.isOn()) {
			for (ContestantView c : unclicked) {
				c.setMerryButtonValue(false);
			}
			clicked.setWikiButtonValue(false);
			clicked.setKillButtonValue(false);
		}
	}

	private void onKillButtonClick(ContestantButtonClickEvent e) {
		ContestantView clicked = e.getContestantSource();
		ArrayList<ContestantView> unclicked = 
						getUnClickedContestantViews(clicked);
		if (e.isOn()) {
			for (ContestantView c : unclicked) {
				c.setKillButtonValue(false);
			}
			clicked.setWikiButtonValue(false);
			clicked.setMerryButtonValue(false);
		}
	}
	
	private ArrayList<ContestantView> getUnClickedContestantViews(ContestantView clickedView) {
		ArrayList<ContestantView> unclicked = new ArrayList<ContestantView>();
		if (clickedView.equals(contestantOne)) {
			unclicked.add(contestantTwo);
			unclicked.add(contestantThree);
		} else if (clickedView.equals(contestantTwo)) {
			unclicked.add(contestantOne);
			unclicked.add(contestantThree);
		} else if (clickedView.equals(contestantThree)) {
			unclicked.add(contestantOne);
			unclicked.add(contestantTwo);
		}
		return unclicked;
	}
	

}
