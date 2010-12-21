package com.wikimerrykill.client.presenter;

import java.util.ArrayList;

import com.wikimerrykill.client.event.ContestantButtonClickEvent;
import com.wikimerrykill.client.event.KillButtonClickEvent;
import com.wikimerrykill.client.event.MerryButtonClickEvent;
import com.wikimerrykill.client.event.WikiButtonClickEvent;
import com.wikimerrykill.client.view.ContestantViewImpl;
import com.wikimerrykill.client.view.GameBoardView.Presenter;

public class GameBoardPresenter implements Presenter {
	private ContestantViewImpl contestantOne;
	private ContestantViewImpl contestantTwo;
	private ContestantViewImpl contestantThree;
	
	public GameBoardPresenter(ContestantViewImpl one, ContestantViewImpl two, ContestantViewImpl three) {
		this.contestantOne = one;
		this.contestantTwo = two;
		this.contestantThree = three;
	}

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
		ContestantViewImpl clicked = e.getContestantSource();
		ArrayList<ContestantViewImpl> unclicked = 
						getUnClickedContestantViews(clicked);
		if (e.isOn()) {
			for (ContestantViewImpl c : unclicked) {
				c.setWikiButtonValue(false);
			}
			clicked.setKillButtonValue(false);
			clicked.setMerryButtonValue(false);
		}
	}

	private void onMerryButtonClick(ContestantButtonClickEvent e) {
		ContestantViewImpl clicked = e.getContestantSource();
		ArrayList<ContestantViewImpl> unclicked = 
						getUnClickedContestantViews(clicked);
		if (e.isOn()) {
			for (ContestantViewImpl c : unclicked) {
				c.setMerryButtonValue(false);
			}
			clicked.setWikiButtonValue(false);
			clicked.setKillButtonValue(false);
		}
	}

	private void onKillButtonClick(ContestantButtonClickEvent e) {
		ContestantViewImpl clicked = e.getContestantSource();
		ArrayList<ContestantViewImpl> unclicked = 
						getUnClickedContestantViews(clicked);
		if (e.isOn()) {
			for (ContestantViewImpl c : unclicked) {
				c.setKillButtonValue(false);
			}
			clicked.setWikiButtonValue(false);
			clicked.setMerryButtonValue(false);
		}
	}
	
	private ArrayList<ContestantViewImpl> getUnClickedContestantViews(ContestantViewImpl clickedView) {
		ArrayList<ContestantViewImpl> unclicked = new ArrayList<ContestantViewImpl>();
		if (clickedView.equals(contestantOne)) {
			unclicked.add(contestantTwo);
			unclicked.add(contestantThree);
		} else if (clickedView.equals(contestantTwo)) {
			unclicked.add(contestantOne);
			unclicked.add(contestantThree);
		} else if (clickedView.equals(contestantThree)) {
			unclicked.add(contestantOne);
			unclicked.add(contestantThree);
		}
		return unclicked;
	}
	

}
