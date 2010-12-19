package com.wikimerrykill.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class NotificationBox extends DialogBox {

	private static NotificationBoxUiBinder uiBinder = GWT
			.create(NotificationBoxUiBinder.class);
	
	private String header;

	interface NotificationBoxUiBinder extends UiBinder<Widget, NotificationBox> {
	}
	
	@UiField Button okButton;
	@UiField Label message;
	
	public NotificationBox(String header) {
		message = new Label();
		okButton = new Button();
		
		
		setWidget(uiBinder.createAndBindUi(this));
		setHeader(header);
		okButton.setText("OK");
		setAnimationEnabled(true);
	    setGlassEnabled(true);
	    center();
	    setText(this.header);
	}
	
	public NotificationBox() {
		this("");
	}
	
	public void setMessage(String text) {
		message.setText(text);
	}
	
	public void setHeader(String text) {
		header = text;
	}
	
	protected void onPreviewNativeEvent(NativePreviewEvent preview) {
		super.onPreviewNativeEvent(preview);

		NativeEvent evt = preview.getNativeEvent();
		if (evt.getType().equals("keydown")) {
			//Use the popup's key preview hooks to close the dialog when either
			//enter or escape is pressed.
			switch (evt.getKeyCode()) {
				case KeyCodes.KEY_ENTER:
				case KeyCodes.KEY_ESCAPE:
					hide();
					break;
			}
		}
	}
	
	@UiHandler("okButton")
	void onOkClicked(ClickEvent event) {
		hide();
	}

}
