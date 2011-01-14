package com.wikimerrykill.client.presenter;

import java.util.ArrayList;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.wikimerrykill.api.search.ImageSearchTool;
import com.wikimerrykill.client.ContestantDO;
import com.wikimerrykill.client.event.ContestantButtonClickEvent;
import com.wikimerrykill.client.event.GameOptionsChangeEvent;
import com.wikimerrykill.client.event.KillButtonClickEvent;
import com.wikimerrykill.client.event.MerryButtonClickEvent;
import com.wikimerrykill.client.event.WikiButtonClickEvent;
import com.wikimerrykill.client.view.ContestantView;
import com.wikimerrykill.client.view.ContestantViewImpl;
import com.wikimerrykill.client.view.GameBoardView;
import com.wikimerrykill.client.view.GameBoardView.Presenter;

public class GameBoardPresenter implements Presenter {
	private GameBoardView gameBoardView;
	private EventBus eventBus;
	
	@Inject
	public GameBoardPresenter(GameBoardView gameBoardView, EventBus eventBus) {
		this.gameBoardView = gameBoardView;
		this.eventBus = eventBus;
		bind();
	}
	
	private void bind() {
		GameOptionsChangeEvent.register(eventBus, this);
		ContestantButtonClickEvent.register(eventBus, this);
	}
	
	public void onGameOptionsChange(GameOptionsChangeEvent e) {
		//get new contestants based on options
		/*
		if (e.getFemaleOn() && e.getMaleOn()) {
			String nameOne = "Courtney Cox";
			String nameTwo = "Courtney Love";
			String nameThree = "Princess Leia Organa";
			
			ImageSearchTool ist = new ImageSearchTool();
			ist.searchImages(null, nameOne);
			
			
			
			ContestantDO one = 
				new ContestantDO(
						"Courtney Love",
						"http://en.wikipedia.org/wiki/Courtney_Love",
						"http://upload.wikimedia.org/wikipedia/commons/thumb/1/18/CourtneyLove1045.png/220px-CourtneyLove1045.png"
				);
			
			ContestantDO two = 
				new ContestantDO(
						"Yoda",
						"http://en.wikipedia.org/wiki/Yoda",
						"http://upload.wikimedia.org/wikipedia/en/thumb/9/96/CGIYoda.jpg/250px-CGIYoda.jpg"
				);
			
			ContestantDO three = 
				new ContestantDO(
						"Princess Leia Organa",
						"http://en.wikipedia.org/wiki/Princess_Leia_Organa",
						"http://upload.wikimedia.org/wikipedia/en/thumb/8/8b/Princess_leia_film.jpg/250px-Princess_leia_film.jpg"
				);
			ContestantViewImpl oneView = new ContestantViewImpl(one);
			ContestantViewImpl twoView = new ContestantViewImpl(two);
			ContestantViewImpl threeView = new ContestantViewImpl(three);
			
			oneView.setPresenter(new ContestantPresenter(eventBus));
			twoView.setPresenter(new ContestantPresenter(eventBus));
			threeView.setPresenter(new ContestantPresenter(eventBus));
			
			gameBoardView.refreshContestants(oneView, twoView, threeView);
		} else if (e.getFemaleOn()) {
			ContestantDO one = 
				new ContestantDO(
						"Courtney Love",
						"http://en.wikipedia.org/wiki/Courtney_Love",
						"http://upload.wikimedia.org/wikipedia/commons/thumb/1/18/CourtneyLove1045.png/220px-CourtneyLove1045.png"
				);
			
			ContestantDO two = 
				new ContestantDO(
						"Courtney Cox",
						"http://en.wikipedia.org/wiki/Courteney_Cox",
						"http://upload.wikimedia.org/wikipedia/commons/0/0f/CourteneyCoxFeb09.jpg"
				);
			
			ContestantDO three = 
				new ContestantDO(
						"Princess Leia Organa",
						"http://en.wikipedia.org/wiki/Princess_Leia_Organa",
						"http://upload.wikimedia.org/wikipedia/en/thumb/8/8b/Princess_leia_film.jpg/250px-Princess_leia_film.jpg"
				);
			ContestantViewImpl oneView = new ContestantViewImpl(one);
			ContestantViewImpl twoView = new ContestantViewImpl(two);
			ContestantViewImpl threeView = new ContestantViewImpl(three);
			
			oneView.setPresenter(new ContestantPresenter(eventBus));
			twoView.setPresenter(new ContestantPresenter(eventBus));
			threeView.setPresenter(new ContestantPresenter(eventBus));
			
			gameBoardView.refreshContestants(oneView, twoView, threeView);
		} else if (e.getMaleOn()) {
			ContestantDO one = 
				new ContestantDO(
						"Jabba The Hutt",
						"http://en.wikipedia.org/wiki/Jabba_the_Hutt",
						"http://upload.wikimedia.org/wikipedia/en/thumb/6/66/JabbatheHuttROTJ.jpg/250px-JabbatheHuttROTJ.jpg"
				);
			
			ContestantDO two = 
				new ContestantDO(
						"Yoda",
						"http://en.wikipedia.org/wiki/Yoda",
						"http://upload.wikimedia.org/wikipedia/en/thumb/9/96/CGIYoda.jpg/250px-CGIYoda.jpg"
				);
			
			ContestantDO three = 
				new ContestantDO(
						"Eddie Van Halen",
						"http://en.wikipedia.org/wiki/Eddie_Van_Halen",
						"http://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Eddie_Van_Halen_2007-11-10.jpg/250px-Eddie_Van_Halen_2007-11-10.jpg"
				);
			ContestantViewImpl oneView = new ContestantViewImpl(one);
			ContestantViewImpl twoView = new ContestantViewImpl(two);
			ContestantViewImpl threeView = new ContestantViewImpl(three);
			
			oneView.setPresenter(new ContestantPresenter(eventBus));
			twoView.setPresenter(new ContestantPresenter(eventBus));
			threeView.setPresenter(new ContestantPresenter(eventBus));
			
			gameBoardView.refreshContestants(oneView, twoView, threeView);
			
		} else {
			gameBoardView.showNoOptions();
		}
		*/
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
		if (clickedView.equals(gameBoardView.getContestantOne())) {
			unclicked.add(gameBoardView.getContestantTwo());
			unclicked.add(gameBoardView.getContestantThree());
		} else if (clickedView.equals(gameBoardView.getContestantTwo())) {
			unclicked.add(gameBoardView.getContestantOne());
			unclicked.add(gameBoardView.getContestantThree());
		} else if (clickedView.equals(gameBoardView.getContestantThree())) {
			unclicked.add(gameBoardView.getContestantOne());
			unclicked.add(gameBoardView.getContestantTwo());
		}
		return unclicked;
	}
	

}
