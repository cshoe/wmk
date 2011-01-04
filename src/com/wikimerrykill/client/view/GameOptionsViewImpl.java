package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;

public class GameOptionsViewImpl extends Composite implements GameOptionsView {

	private static GameOptionsViewImplUiBinder uiBinder = GWT
			.create(GameOptionsViewImplUiBinder.class);

	interface GameOptionsViewImplUiBinder extends UiBinder<Widget, GameOptionsViewImpl> {}
	
	@UiField ToggleButton maleToggle;
	@UiField ToggleButton femaleToggle;
	@UiField Label maleLabel;
	@UiField Label femaleLabel;
	
	private Presenter presenter;
	
	public GameOptionsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		maleToggle.setText("Male");
		femaleToggle.setText("Female");
		femaleToggle.setDown(true);
		setLabels();
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("maleToggle")
	void onMaleClick(ClickEvent e) {
		if (presenter != null) {
			presenter.onMaleClicked(maleToggle.isDown(), femaleToggle.isDown(), maleLabel);
		}
	}
	
	@UiHandler("femaleToggle")
	void onFemaleClick(ClickEvent e) {
		if (presenter != null) {
			presenter.onFemaleClicked(femaleToggle.isDown(), maleToggle.isDown(), femaleLabel);
		}
	}
	
	private void setLabels() {
		String maleText = 
			maleToggle.isDown() ? "Male on" : "Male off";
		maleLabel.setText(maleText);
		
		String femalText = 
			femaleToggle.isDown() ? "Femal on" : "Female off";
		femaleLabel.setText(femalText);
	}
	
}
