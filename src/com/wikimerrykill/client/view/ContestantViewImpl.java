package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
import com.wikimerrykill.api.search.ImageSearchTool;

public class ContestantViewImpl extends Composite implements ContestantView {

	private static ContestantViewImplUiBinder uiBinder = GWT
			.create(ContestantViewImplUiBinder.class);

	interface ContestantViewImplUiBinder extends UiBinder<Widget, ContestantViewImpl> {
	}

	@UiField Anchor link;
	@UiField Image image;
	@UiField ToggleButton wikiButton;
	@UiField ToggleButton merryButton;
	@UiField ToggleButton killButton; 
	
	private Presenter presenter;
	
	public ContestantViewImpl() {
		init();
		
		initWidget(uiBinder.createAndBindUi(this));
		/*link.setHref(data.getPageUrl());
		link.setText(data.getName());
		image.setUrl(data.getImageUrl());
		wikiButton.setText("Wiki");
		merryButton.setText("Merry");
		killButton.setText("Kill");
		*/
	}
	
	private void init() {
		
	}
	
	@UiHandler("wikiButton")
	void onWikiClick(ClickEvent e) {
		if (presenter != null) {
			presenter.onWikiChange(this, wikiButton.isDown());
		}
	}
	
	@UiHandler("merryButton")
	void onMerryClick(ClickEvent e) {
		if (presenter != null) {
			presenter.onMerryChange(this, merryButton.isDown());	
		}
	}
	
	@UiHandler("killButton")
	void onKillClick(ClickEvent e) {
		if (presenter != null) {
			presenter.onKillChange(this, killButton.isDown());
		}
	}
	
	//Getters
	public ToggleButton getWikiButton() {
		return wikiButton;
	}
	
	public ToggleButton getMerryButton() {
		return merryButton;
	}
	
	public ToggleButton getKillButton() {
		return killButton;
	}
	
	//Setters
	public void setWikiButtonValue(boolean toWiki) {
		wikiButton.setValue(toWiki, false);
	}
	
	public void setWikiButtonEnabled(boolean isEnabled) {
		wikiButton.setEnabled(isEnabled);
	}
	
	public void setMerryButtonValue(boolean toMerry) {
		merryButton.setValue(toMerry, false);
	}
	
	public void setMerryButtonEnabled(boolean isEnabled) {
		merryButton.setEnabled(isEnabled);
	}
	
	public void setKillButtonValue(boolean toKill) {
		killButton.setValue(toKill, false);
	}
	
	public void setKillButtonEnabled(boolean isEnabled) {
		killButton.setEnabled(isEnabled);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public void hide() {
		this.setVisible(false);
	}
	
	public void show() {
		this.setVisible(true);
	}

}
