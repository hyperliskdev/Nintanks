package dev.hyperlisk.nintanks.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;
import dev.hyperlisk.nintanks.entities.Player;
import dev.hyperlisk.nintanks.entities.Wall;
import dev.hyperlisk.nintanks.util.InputHandler;
import dev.hyperlisk.nintanks.util.MapHandler;

import java.util.ArrayList;

public class GameState extends State {

    // Objects needed for the GameState
    Player player = new Player();
    InputHandler input = new InputHandler();
    ArrayList<Wall> walls = MapHandler.getInstance().getWalls();

    public GameState(StateManager stateManager) {
        super(stateManager);

    }

    @Override
    protected void handleInput() {

        Gdx.input.setInputProcessor(input);

    }

    @Override
    public void update(float dt) {
        handleInput();
        player.update(dt);

    }

    @Override
    public void render(SpriteBatch b) {


        for (Wall w: walls) {
            w.render(b);

        }

        player.render(b);

    }

    @Override
    public void dispose() {
    }
}
