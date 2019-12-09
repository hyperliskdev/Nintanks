package dev.hyperlisk.nintanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.hyperlisk.nintanks.entities.Player;
import dev.hyperlisk.nintanks.states.StateManager;

import static dev.hyperlisk.nintanks.Reference.VIEWPORT_HEIGHT;
import static dev.hyperlisk.nintanks.Reference.VIEWPORT_WIDTH;

public class Nintanks extends ApplicationAdapter {

	SpriteBatch sb;
	StateManager stateManager;
	OrthographicCamera cam;
	Texture img;
	Player player;

	
	@Override
	public void create () {
		cam = stateManager.currentState().getCam();

		cam.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		sb = new SpriteBatch();
		sb.setProjectionMatrix(cam.combined);

		player = new Player();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float dt = Gdx.graphics.getDeltaTime();
		player.update(dt);

		sb.begin();
		player.render(sb);

		sb.end();



	}
	
	@Override
	public void dispose () {

	}
}
