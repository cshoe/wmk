package com.wikimerrykill.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Body extends Composite {

	private static BodyUiBinder uiBinder = GWT.create(BodyUiBinder.class);

	interface BodyUiBinder extends UiBinder<Widget, Body> {
	}
	
	
	

	public Body() {
		
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiFactory GameBoard makeGameBoard() {
		ContestantDO one = 
			new ContestantDO(
					"Courtney Love",
					"http://en.wikipedia.org/wiki/Courtney_Love",
					"http://upload.wikimedia.org/wikipedia/commons/thumb/1/18/CourtneyLove1045.png/220px-CourtneyLove1045.png"
			);
		
		ContestantDO two = 
			new ContestantDO(
					"Courtney Cox",
					"http://en.wikipedia.org/wiki/Courteney_Cox",
					"http://upload.wikimedia.org/wikipedia/commons/0/0f/CourteneyCoxFeb09.jpg"
			);
		
		ContestantDO three = 
			new ContestantDO(
					"Princess Leia Organa",
					"http://en.wikipedia.org/wiki/Princess_Leia_Organa",
					"http://upload.wikimedia.org/wikipedia/en/8/8b/Princess_leia_film.jpg"
			);
		
		return  new GameBoard(
					new Contestant(one), 
					new Contestant(two),
					new Contestant(three)
		);
	}

}
