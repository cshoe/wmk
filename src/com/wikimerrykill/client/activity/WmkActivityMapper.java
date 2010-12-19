package com.wikimerrykill.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.wikimerrykill.client.place.GamePlace;

public class WmkActivityMapper implements ActivityMapper {

	private GameActivity gameActivity;
	
	
	@Inject
	public WmkActivityMapper(GameActivity gameActivity) {
		this.gameActivity = gameActivity;
	}
	
	public Activity getActivity(Place place) {
		if (place instanceof GamePlace) {
			return gameActivity;
		}
		
		//not a known activity
		return null;
	}

}
