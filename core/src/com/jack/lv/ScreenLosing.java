package com.jack.lv;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class ScreenLosing implements Screen{

	LV lv;
	
	public ScreenLosing(LV lv) {
		// TODO Auto-generated constructor stub
		this.lv = lv;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.app.exit();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
