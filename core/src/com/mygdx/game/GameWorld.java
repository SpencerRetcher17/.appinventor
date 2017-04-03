package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Rectangle head;
	float time;
	boolean left;
	boolean right=true;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Arcade-Centipede-Centipede_03.png");

		// create a Rectangle to logically represent the bucket
		head = new Rectangle();
		head.x = 800 / 2 - 64 / 2; // center the bucket horizontally
		head.y = 20; // bottom left corner of the bucket is 20 pixels above
		// the bottom screen edge
		head.width = 60;
		head.height = 30;


		 camera = new OrthographicCamera();
		camera.setToOrtho(true, 800, 480);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// tell the camera to update its matrices.
		camera.update();

		// tell the SpriteBatch to render in the
		// coordinate system specified by the camera.
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(img, head.x, head.y,head.width,head.height);
		batch.end();

		head.x-=200*Gdx.graphics.getDeltaTime();

		/*
		if(head.x>0&&left==true)
		{
			time =200 * Gdx.graphics.getDeltaTime();
			left=true;
			head.x-=time;
		}

		if (head.x <=0)
		{
			time =200 * Gdx.graphics.getDeltaTime();
			left=false;
			head.x+=time;
		}
		 if(head.x>=800)
		{
			time =200 * Gdx.graphics.getDeltaTime();
			left=true;
			head.x-=time;
		}
		*/




	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
