package com.wikimerrykill.client.presenter;

import com.google.gwt.user.client.ui.HasDirectionalText;
import com.wikimerrykill.client.NotificationBox;
import com.wikimerrykill.client.view.GameOptionsView;

public class GameOptionsPresenter implements GameOptionsView.Presenter {

	public void onFemaleClicked(boolean isOn) {
		NotificationBox n = new NotificationBox("YO");
		if (isOn) {
			n.setMessage("Female on");
		} else {
			n.setMessage("Female off");
		}
		n.show();
	}

	public void onMaleClicked(boolean isOn) {
		NotificationBox n = new NotificationBox("YO");
		if (isOn) {
			n.setMessage("Male on");
		} else {
			n.setMessage("Male off");
		}
		n.show();
	}

	public void onFemaleClicked(boolean isOn, HasDirectionalText l) {
		if (isOn) {
			l.setText("Female on");
		} else {
			l.setText("Female off");
		}
	}

	public void onMaleClicked(boolean isOn, HasDirectionalText l) {
		if (isOn) {
			l.setText("Male on");
		} else {
			l.setText("Male off");
		}
	}

}
