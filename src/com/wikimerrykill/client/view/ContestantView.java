package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
import com.wikimerrykill.client.ContestantDO;

public class ContestantView extends Composite implements HasHandlers {

	private static ContestantViewUiBinder uiBinder = GWT
			.create(ContestantViewUiBinder.class);

	interface ContestantViewUiBinder extends UiBinder<Widget, ContestantView> {
	}

	@UiField Anchor link;
	@UiField Image image;
	@UiField ToggleButton wikiButton;
	@UiField ToggleButton merryButton;
	@UiField ToggleButton killButton; 
	
	
	public ContestantView(ContestantDO data) {
		initWidget(uiBinder.createAndBindUi(this));
		link.setHref(data.getPageUrl());
		link.setText(data.getName());
		image.setUrl(data.getImageUrl());
		wikiButton.setText("Wiki");
		merryButton.setText("Merry");
		killButton.setText("Kill");
	}
	
	public ToggleButton getWikiButton() {
		return wikiButton;
	}
	
	public ToggleButton getMerryButton() {
		return merryButton;
	}
	
	public ToggleButton getKillButton() {
		return killButton;
	}

}
