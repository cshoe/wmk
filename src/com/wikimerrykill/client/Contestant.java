package com.wikimerrykill.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class Contestant extends Composite {

	private static ContestantUiBinder uiBinder = GWT
			.create(ContestantUiBinder.class);

	interface ContestantUiBinder extends UiBinder<Widget, Contestant> {
	}
	
	@UiField Anchor link;
	@UiField Image image;
	
	@UiConstructor
	public Contestant(ContestantDO data) {
		initWidget(uiBinder.createAndBindUi(this));
		link.setHref(data.getPageUrl());
		link.setText(data.getName());
		image.setUrl(data.getImageUrl());
	}

}
