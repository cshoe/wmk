package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.wikimerrykill.client.event.KillButtonClickEvent;
import com.wikimerrykill.client.event.MerryButtonClickEvent;
import com.wikimerrykill.client.event.WikiButtonClickEvent;
import com.wikimerrykill.client.presenter.GameBoardPresenter;

public class GameBoardViewImpl extends Composite implements GameBoardView {

	private static GameBoardViewImplUiBinder uiBinder = GWT
			.create(GameBoardViewImplUiBinder.class);

	interface GameBoardViewImplUiBinder extends
			UiBinder<Widget, GameBoardViewImpl> {
	}
	
	@UiField(provided=true) ContestantViewImpl numberOne;
	@UiField(provided=true) ContestantViewImpl numberTwo;
	@UiField(provided=true) ContestantViewImpl numberThree;
	
	private Presenter presenter;
	private EventBus eventBus;
	
	@Inject
	public GameBoardViewImpl(ContestantViewImpl one, ContestantViewImpl two, ContestantViewImpl three, EventBus eventBus) {
		numberOne = one;
		numberTwo = two;
		numberThree = three;
		setPresenter(new GameBoardPresenter(numberOne, numberTwo, numberThree));
		this.eventBus = eventBus;
		init();
		
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	private void init() {
		WikiButtonClickEvent.register(eventBus, presenter);
		MerryButtonClickEvent.register(eventBus, presenter);
		KillButtonClickEvent.register(eventBus, presenter);
	}
	
	public ContestantViewImpl getContestantOne() {
		return numberOne;
	}

	public ContestantViewImpl getContestantTwo() {
		return numberTwo;
	}

	public ContestantViewImpl getContestantThree() {
		return numberThree;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
