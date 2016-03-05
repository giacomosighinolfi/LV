package com.jack.lv;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class ScreenGame implements Screen{
	
	SpriteBatch batch;
	Player player;
	OrthographicCamera camera;
	Map map;
	BitmapFont font;
	LV lv;
	
	public ScreenGame(LV lv) {
		// TODO Auto-generated constructor stub
		map = new Map();
		player = new Player(map.start());
		batch = new SpriteBatch();
		camera = new OrthographicCamera(640*Gdx.graphics.getWidth()/Gdx.graphics.getHeight(),640);
		//camera = new OrthographicCamera(240,240);
		camera.position.set(0, 0, 0);
		camera.update();
		this.lv = lv;
		font = new BitmapFont();
		font.setColor(Color.LIME);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		player.set(Gdx.input.getAccelerometerX(), Gdx.input.getAccelerometerY());
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		player.Move();
		player.Move(Gdx.input.getAccelerometerX(), Gdx.input.getAccelerometerY());
		player.X = MathUtils.clamp(player.X, 0, map.width());
		player.Y = MathUtils.clamp(player.Y, 0, map.height());
		
		camera.position.set(player.X, player.Y, 0);
		
		camera.position.x = MathUtils.clamp(camera.position.x, camera.viewportWidth*camera.zoom/2, map.width()-camera.viewportWidth*camera.zoom/2);
		camera.position.y = MathUtils.clamp(camera.position.y, camera.viewportHeight*camera.zoom/2, map.height()-camera.viewportHeight*camera.zoom/2);

		
		camera.update();
		map.draw(batch, camera);
		
		batch.begin();
		player.draw(batch);
		font.draw(batch, "\n\n\n\n"+Gdx.graphics.getFramesPerSecond(),	player.X, player.Y);
		batch.end();
		if(map.end(player))
			lv.setScreen(lv.Menu);
		if(map.ostacle(player))
			lv.setScreen(lv.Menu);
		
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
