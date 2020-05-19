package com.ivanimg.variety;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class VarietyGame extends Game {
	public SpriteBatch batch;
	/*Texture img;
	private Skin skin = new Skin();
	private Stage stage;
	float x,y;*/
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		//Para elegir la pantalla que se lanzará
		//this.setScreen(new ScreenQueElijamos());
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
		/*Gdx.gl.glClearColor(130, 130, 130, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int ancho = Gdx.graphics.getWidth();
		int largo = Gdx.graphics.getHeight();

		stage = new Stage();
		Table table = new Table();
		table.setPosition(ancho,largo);
		table.setFillParent(true);
		stage.addActor(table);

		Label label = new Label("Bievenido, elige un juego", skin);
		table.addActor(label);

		TextButton buttonInicio = new TextButton("Pong",skin);

		batch.begin();
		//batch.draw(img, 0, 0);
		batch.draw(img, x, y);
		batch.end();*/
	}
	/*
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}*/
}
