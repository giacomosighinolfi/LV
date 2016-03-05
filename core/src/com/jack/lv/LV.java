package com.jack.lv;

import com.badlogic.gdx.Game;

public class LV extends Game {
	ScreenMenu Menu;
	ScreenGame Game;
	ScreenLosing Lose;
	ScreenOpening Open;

	@Override
	public void create () {
		Lose = new ScreenLosing(this);
		Menu = new ScreenMenu(this);
		Game = new ScreenGame(this);
		Open = new ScreenOpening(this);
		this.setScreen(Open);
	}

	
}
