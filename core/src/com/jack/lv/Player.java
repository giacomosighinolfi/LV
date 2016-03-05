package com.jack.lv;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

	float x,y;
	float ax,ay;
	float X,Y;
	Vector2 accel;
	Texture texture;
	Sprite img;
	Rectangle rectangle;

	public Player(Vector2 start){
		X=start.x;
		Y=start.y;
		accel = new Vector2(0,0);
		texture = new Texture("ball-50x50.png");
		img = new Sprite(texture);
		rectangle = new Rectangle();
		rectangle.setCenter(X,Y);
		rectangle.setWidth(img.getWidth()/(float)(Math.sqrt(2)));
		rectangle.setHeight(img.getHeight()/(float)(Math.sqrt(2)));
	}

	public void Move(){
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			X-=Gdx.graphics.getDeltaTime()*600;
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			X+=Gdx.graphics.getDeltaTime()*600;
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
			Y+=Gdx.graphics.getDeltaTime()*600;
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			Y-=Gdx.graphics.getDeltaTime()*600;

		rectangle.setCenter(X, Y);
	}

	public void Move(float accelX, float accelY){


		x = (accelX - ax);
		y = (accelY - ay);
		x = MathUtils.clamp(x, -3, 3);
		y = MathUtils.clamp(y, -3, 3);		

		if(accel.x < x)
			accel.x += Math.abs(accel.x - x)*Gdx.graphics.getDeltaTime();
		else
			accel.x -= Math.abs(accel.x - x)*Gdx.graphics.getDeltaTime();
		if(accel.y < y)
			accel.y += Math.abs(accel.y - y)*Gdx.graphics.getDeltaTime();
		else
			accel.y -= Math.abs(accel.y - y)*Gdx.graphics.getDeltaTime();


		accel.x = MathUtils.clamp(accel.x, -5,5);
		accel.y = MathUtils.clamp(accel.y, -5,5);


		if(Math.abs(accel.x)>0.33f)
			Y -= 3.33*accel.x;

		if(Math.abs(accel.y)>0.33f)
			X += 3.33*accel.y;

		rectangle.setCenter(X, Y);
	}

	public void draw(SpriteBatch batch){
		img.setCenter(X, Y);
		img.draw(batch);

	}

	public void set(float accelerometerX, float accelerometerY) {
		// TODO Auto-generated method stub
		ax=accelerometerX;
		ay=accelerometerY;
		accel.set(ax, ay);
	}


	public Rectangle getRectangle() {
		// TODO Auto-generated method stub
		return rectangle;
	}


}
