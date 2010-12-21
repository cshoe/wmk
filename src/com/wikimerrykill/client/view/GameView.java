package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.wikimerrykill.client.ContestantDO;
import com.wikimerrykill.client.presenter.GameOptionsPresenter;

public class GameView extends Composite {

	private static GameViewUiBinder uiBinder = GWT
			.create(GameViewUiBinder.class);

	interface GameViewUiBinder extends UiBinder<Widget, GameView> {}
	
	@UiField GameOptionsViewImpl options; 
	@UiField GameBoardViewImpl board;
	
	private EventBus eventBus;
	
	@Inject
	public GameView(EventBus eventBus) {
		initWidget(uiBinder.createAndBindUi(this));
		options.setPresenter(new GameOptionsPresenter());
		this.eventBus = eventBus;
	}
	
	public GameOptionsView getGameOptions() {
		return options;
	}
	
	@UiFactory GameBoardViewImpl makeGameBoard() {
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
					"http://upload.wikimedia.org/wikipedia/en/8/8b/Princess_leia_film.jpg"
			);
		
		return  new GameBoardViewImpl(
					new ContestantViewImpl(one), 
					new ContestantViewImpl(two),
					new ContestantViewImpl(three),
					eventBus
		);
	}

}
