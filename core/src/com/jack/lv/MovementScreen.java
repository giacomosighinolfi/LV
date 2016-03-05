package com.jack.lv;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MovementScreen {
	float x,y,X,Y, cx,cy;
	float speed;
	OrthographicCamera camera;

	public MovementScreen(float sX, float sY){
		Y = 33.33f;
		X = 33.33f;
		
		speed=300;
		x=sX;
		y=sY;
		cx=0;
		cy=0;
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//camera.position.set(0, 0, 0);
		camera.update();
		
	}


	


	public void checkXY(float Xm, float XM, float Ym, float YM, float size) {
		// TODO Auto-generated method stub
		if(X<size)
			X=size;
		if(X>XM-size)
			X=XM-size;
		if(Y<size)
			Y=size;
		if(Y>YM-size)
			Y=YM-size;
		camera.position.set(X,Y,0);
		//translate(XM, YM);
		camera.update();
	}


	public void translate(float XM, float YM) {
		// TODO Auto-generated method stub

		if(Y < Gdx.graphics.getHeight()*0.5){
			//status=4;
			cy= (float) (Gdx.graphics.getHeight() - Y);
		}
		else if(Y > YM - Gdx.graphics.getHeight()){
			//status=5;
			cy= (-Y+YM-Gdx.graphics.getHeight()/2);
		}
		else {
			cy=0;
		}
		if(X < Gdx.graphics.getWidth()*0.5){
			//status=4;
			cx= (float) (Gdx.graphics.getWidth()-X);
		}
		else if(X >  XM - Gdx.graphics.getWidth()){
			//status=5;
			cx= (-X+XM-Gdx.graphics.getWidth()/2);
		}
		else {
			cx=0;
		}
		camera.translate(cx, cy);

	}



}
