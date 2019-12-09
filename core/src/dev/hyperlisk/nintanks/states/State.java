package dev.hyperlisk.nintanks.states;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.Vector;

public abstract class State {


    // Thanks @Volxz!
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected StateManager stateManager;
    protected Input.Keys keys;

    protected State(StateManager stateManager){
        this.stateManager = stateManager;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }


    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch b);
    public abstract void dispose();
}
