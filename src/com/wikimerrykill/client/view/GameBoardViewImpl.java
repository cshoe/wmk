package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.wikimerrykill.client.Contestant;

public class GameBoardViewImpl extends Composite implements GameBoardView {

	private static GameBoardViewImplUiBinder uiBinder = GWT
			.create(GameBoardViewImplUiBinder.class);

	interface GameBoardViewImplUiBinder extends
			UiBinder<Widget, GameBoardViewImpl> {
	}
	
	@UiField(provided=true) Contestant numberOne;
	@UiField(provided=true) Contestant numberTwo;
	@UiField(provided=true) Contestant numberThree;

	public GameBoardViewImpl(Contestant one, Contestant two, Contestant three) {
		numberOne = one;
		numberTwo = two;
		numberThree = three;
		
		initWidget(uiBinder.createAndBindUi(this));
	}

}
