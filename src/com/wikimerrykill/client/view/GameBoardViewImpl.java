package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.wikimerrykill.client.event.ContestantButtonClickEvent;
import com.wikimerrykill.client.presenter.GameBoardPresenter;

public class GameBoardViewImpl extends Composite implements GameBoardView {

	private static GameBoardViewImplUiBinder uiBinder = GWT
			.create(GameBoardViewImplUiBinder.class);

	interface GameBoardViewImplUiBinder extends
			UiBinder<Widget, GameBoardViewImpl> {
	}
	
	@UiField FlowPanel panel; 
	ContestantView numberOne;
	ContestantView numberTwo;
	ContestantView numberThree;
	
	private Presenter presenter;
	private EventBus eventBus;
	
	@Inject
	public GameBoardViewImpl(ContestantViewImpl one, ContestantViewImpl two, ContestantViewImpl three, EventBus eventBus) {
		numberOne = one;
		numberTwo = two;
		numberThree = three;
		this.eventBus = eventBus;
		setPresenter(new GameBoardPresenter(this, this.eventBus));
		init();
		
		initWidget(uiBinder.createAndBindUi(this));
		
		panel.add(one);
		panel.add(two);
		panel.add(three);
	}
	
	private void init() {
		ContestantButtonClickEvent.register(eventBus, presenter);
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
	
	public void setContestantOne(ContestantViewImpl c) {
		numberOne = c;
	}
	
	public void setContestantTwo(ContestantViewImpl c) {
		numberTwo = c;
	}
	
	public void setContestantThree(ContestantViewImpl c) {
		numberThree = c;
	}
	
	public void refreshContestants(ContestantViewImpl one, ContestantViewImpl two, ContestantViewImpl three) {
		hideContestants();
		changeContestants(one, two, three);
		showContestants();
	}
	
	public void hideContestants() {
		panel.remove(numberOne);
		panel.remove(numberTwo);
		panel.remove(numberThree);
	}
	
	public void changeContestants(ContestantViewImpl one, ContestantViewImpl two, ContestantViewImpl three) {
		setContestantOne(one);
		setContestantTwo(two);
		setContestantThree(three);
	}
	
	public void showContestants() {
		panel.add(numberOne);
		panel.add(numberTwo);
		panel.add(numberThree);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
