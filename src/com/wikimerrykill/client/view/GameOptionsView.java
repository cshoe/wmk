package com.wikimerrykill.client.view;

import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.IsWidget;

public interface GameOptionsView extends IsWidget {
	
	public interface Presenter {
		void onMaleClicked(boolean maleOn, boolean femaleOn);
		void onFemaleClicked(boolean femaleOn, boolean maleOn);
		void onMaleClicked(boolean maleOn, boolean femaleOn, HasDirectionalText l);
		void onFemaleClicked(boolean isOn, boolean femaleOn, HasDirectionalText l);
	}
	
	void setPresenter(Presenter presenter);
}
