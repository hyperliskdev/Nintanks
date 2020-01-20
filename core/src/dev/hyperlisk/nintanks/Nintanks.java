package dev.hyperlisk.nintanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.hyperlisk.nintanks.entities.Player;
import dev.hyperlisk.nintanks.entities.Wall;
import dev.hyperlisk.nintanks.states.GameState;
import dev.hyperlisk.nintanks.states.State;
import dev.hyperlisk.nintanks.states.StateManager;
import dev.hyperlisk.nintanks.util.InputHandler;
import dev.hyperlisk.nintanks.util.MapHandler;

import java.io.IOException;
import java.util.ArrayList;

public class Nintanks extends ApplicationAdapter {

	private static Nintanks instance = null;

	private StateManager gsm;
	private SpriteBatch sb;

	private Nintanks() {

	}

	public static Nintanks getInstance() {
		if(instance == null) {
			instance = new Nintanks();
		}
		return instance;
	}

	@Override
	public void create () {
		sb = new SpriteBatch();
		gsm = new StateManager();
		gsm.push(new GameState(gsm));
	}

	@Override
	public void render () {

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);

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
