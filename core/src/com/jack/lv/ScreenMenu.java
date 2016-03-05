package com.jack.lv;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenMenu implements Screen{
	
	LV lv;
	BitmapFont font;
	SpriteBatch batch;
	
	public ScreenMenu(LV lv) {
		// TODO Auto-generated constructor stub
		this.lv = lv;
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		batch = new SpriteBatch();
		font.getData().setScale(font.getScaleX()*4);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "touch the screen\nfor start playing", 0, Gdx.graphics.getHeight());
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
			lv.setScreen(lv.Game);
		if(Gdx.input.isTouched())
			lv.setScreen(lv.Game);
		batch.end();
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
