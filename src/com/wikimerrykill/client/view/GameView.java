package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.wikimerrykill.client.presenter.GameBoardPresenter;
import com.wikimerrykill.client.presenter.GameOptionsPresenter;

public class GameView extends Composite {

	private static GameViewUiBinder uiBinder = GWT
			.create(GameViewUiBinder.class);

	interface GameViewUiBinder extends UiBinder<Widget, GameView> {}
	
	@UiField GameOptionsView options; 
	@UiField GameBoardView board;
	
	@Inject
	public GameView(EventBus eventBus) {
		initWidget(uiBinder.createAndBindUi(this));
		options.setPresenter(new GameOptionsPresenter(eventBus));
		board.setPresenter(new GameBoardPresenter(board, eventBus));
	}
	
	public GameOptionsView getGameOptions() {
		return options;
	}
	
	public void setGameBoardView(GameBoardView g) {
		this.board = g;
	}
}