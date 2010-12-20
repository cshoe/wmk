package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GameBoardViewImpl extends Composite implements GameBoardView {

	private static GameBoardViewImplUiBinder uiBinder = GWT
			.create(GameBoardViewImplUiBinder.class);

	interface GameBoardViewImplUiBinder extends
			UiBinder<Widget, GameBoardViewImpl> {
	}
	
	@UiField(provided=true) ContestantView numberOne;
	@UiField(provided=true) ContestantView numberTwo;
	@UiField(provided=true) ContestantView numberThree;
	
	private Presenter presenter;

	public GameBoardViewImpl(ContestantView one, ContestantView two, ContestantView three) {
		numberOne = one;
		numberTwo = two;
		numberThree = three;
		
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public ContestantView getContestantOne() {
		return numberOne;
	}

	public ContestantView getContestantTwo() {
		return numberTwo;
	}

	public ContestantView getContestantThree() {
		return numberThree;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
