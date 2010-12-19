package com.wikimerrykill.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class Shell extends Composite {

	private static ShellUiBinder uiBinder = GWT.create(ShellUiBinder.class);

	interface ShellUiBinder extends UiBinder<Widget, Shell> {
	}
	
	@UiField SimplePanel content;
	
	public Shell() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public SimplePanel getContent(){
		return content;
	}

}
