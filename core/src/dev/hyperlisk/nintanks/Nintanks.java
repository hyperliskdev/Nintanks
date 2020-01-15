package dev.hyperlisk.nintanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.hyperlisk.nintanks.entities.Player;
import dev.hyperlisk.nintanks.entities.Wall;
import dev.hyperlisk.nintanks.states.State;
import dev.hyperlisk.nintanks.states.StateManager;
import dev.hyperlisk.nintanks.util.InputHandler;
import dev.hyperlisk.nintanks.util.MapHandler;

import java.io.IOException;
import java.util.ArrayList;

public class Nintanks extends ApplicationAdapter {

	private static Nintanks instance = null;

	// Object Stubs
	private SpriteBatch sb;
	private Player player;
	private InputHandler input;
	public MapHandler mapHandler;
	private StateManager gsm;
	private State state;

	private Nintanks() {}

	public static Nintanks getInstance() {
		if(instance == null) {
			instance = new Nintanks();
		}
		return instance;

	}

	@Override
	public void create () {

		// Create objects
		sb = new SpriteBatch();
		mapHandler = new MapHandler();
		player = new Player();
		input = new InputHandler();


		Gdx.input.setInputProcessor(input);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float dt = Gdx.graphics.getDeltaTime();

		for (Wall w: mapHandler.getWalls()) {
			w.update(dt);
			w.render(sb);
		}

		player.update(dt);

		player.render(sb);

	}
	
	@Override
	public void dispose () {


	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
