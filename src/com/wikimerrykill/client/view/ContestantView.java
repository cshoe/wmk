package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.wikimerrykill.client.ContestantDO;

public class ContestantView extends Composite {

	private static ContestantViewUiBinder uiBinder = GWT
			.create(ContestantViewUiBinder.class);

	interface ContestantViewUiBinder extends UiBinder<Widget, ContestantView> {
	}

	@UiField Anchor link;
	@UiField Image image;
	
	public ContestantView(ContestantDO data) {
		initWidget(uiBinder.createAndBindUi(this));
		link.setHref(data.getPageUrl());
		link.setText(data.getName());
		image.setUrl(data.getImageUrl());
	}

}
