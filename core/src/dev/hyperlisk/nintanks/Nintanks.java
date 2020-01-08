package dev.hyperlisk.nintanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.hyperlisk.nintanks.entities.Player;
import dev.hyperlisk.nintanks.entities.Wall;
import dev.hyperlisk.nintanks.states.StateManager;
import dev.hyperlisk.nintanks.util.InputHandler;
import dev.hyperlisk.nintanks.util.MapHandler;

import java.io.IOException;

public class Nintanks extends ApplicationAdapter {

	SpriteBatch sb;
	Player player;
	InputHandler input;
	MapHandler mapHandler;


	@Override
	public void create () {

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
}
