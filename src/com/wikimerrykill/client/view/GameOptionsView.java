package com.wikimerrykill.client.view;

import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.IsWidget;

public interface GameOptionsView extends IsWidget {
	
	public interface Presenter {
		void onMaleClicked(boolean isOn);
		void onFemaleClicked(boolean isOn);
		void onMaleClicked(boolean isOn, HasDirectionalText l);
		void onFemaleClicked(boolean isOn, HasDirectionalText l);
	}
	
	void setPresenter(Presenter presenter);
}
