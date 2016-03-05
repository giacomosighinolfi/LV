package com.jack.lv;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
//import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
//import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Map extends Actor{
	Vector2 ret;
	Rectangle rectangle;
	TiledMap map;
	TiledMapTileLayer layer;
	MapObjects MO_lose, MO_init, MO_end;
	RectangleMapObject RMO_lose, RMO_init, RMO_end;
	OrthogonalTiledMapRenderer renderer;
	MapProperties prop;
	int mapW, mapH, pixW, pixH;
	int i;

	public Map(){
		ret = new Vector2();
		map = new TmxMapLoader().load("prova.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		//layer = (TiledMapTileLayer)map.getLayers().get("obj");

		MO_lose = map.getLayers().get("lose").getObjects();
		for (i = 0; i < MO_lose.getCount(); i++) 
			RMO_lose = (RectangleMapObject) MO_lose.get(i);

		MO_init = map.getLayers().get("init").getObjects();
		for (i = 0; i < MO_init.getCount(); i++) 
			RMO_init = (RectangleMapObject) MO_init.get(i);

		MO_end = map.getLayers().get("end").getObjects();
		for (i = 0; i < MO_end.getCount(); i++) 
			RMO_end = (RectangleMapObject) MO_end.get(i);

		prop = map.getProperties();
		mapW = prop.get("width", Integer.class);
		mapH = prop.get("height", Integer.class);
		pixW = prop.get("tilewidth", Integer.class);
		pixH = prop.get("tileheight", Integer.class);

	}

	public void draw(SpriteBatch batch, OrthographicCamera camera){

		renderer.setView(camera);
		renderer.render();
	}

	public float width() {
		// TODO Auto-generated method stub
		return mapW*pixW;
	}

	public float height() {
		// TODO Auto-generated method stub
		return mapH*pixH;
	}

	public Vector2 start (){
		for (RectangleMapObject rectangleObject : MO_init.getByType(RectangleMapObject.class)) {
			rectangle = rectangleObject.getRectangle();
			rectangle.getCenter(ret);
		}
		return ret;
	}

	public boolean ostacle(Player player){

		for (RectangleMapObject rectangleObject : MO_lose.getByType(RectangleMapObject.class)) {

			rectangle = rectangleObject.getRectangle();
			if (rectangle.overlaps(player.getRectangle()))
				// collision happened
				return true;
		}
		return false;
	}

	public boolean end(Player player){

		for (RectangleMapObject rectangleObject : MO_end.getByType(RectangleMapObject.class)) {

			rectangle = rectangleObject.getRectangle();
			if (rectangle.overlaps(player.getRectangle()))
				// collision happened
				return true;
		}
		return false;
	}

}
