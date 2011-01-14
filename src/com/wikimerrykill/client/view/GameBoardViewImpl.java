package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

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
	
	@Inject
	public GameBoardViewImpl() {
		init();
		
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	private void init() {
		numberOne = new ContestantViewImpl();
		numberTwo = new ContestantViewImpl();
		numberThree = new ContestantViewImpl();
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
		clear();
		changeContestants(one, two, three);
		showContestants();
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
	
	public void clear() {
		panel.clear();
	}
	
	public void showNoOptions() {
		clear();
		Label l = new Label();
		l.setText("Need some options");
		panel.add(l);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void addContestant(ContestantView cv) {
		panel.add(cv);
	}
}
