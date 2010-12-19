package com.wikimerrykill.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GameBoard extends Composite {

	private static GameBoardUiBinder uiBinder = GWT
			.create(GameBoardUiBinder.class);

	interface GameBoardUiBinder extends UiBinder<Widget, GameBoard> {
	}
	
	@UiField(provided=true) 
	Contestant numberOne;
	@UiField(provided=true)
	Contestant numberTwo;
	@UiField(provided=true)
	Contestant numberThree;
	
	public GameBoard(Contestant one, Contestant two, Contestant three) {
		numberOne = one;
		numberTwo = two;
		numberThree = three;
		
		initWidget(uiBinder.createAndBindUi(this));
	}
	
}
