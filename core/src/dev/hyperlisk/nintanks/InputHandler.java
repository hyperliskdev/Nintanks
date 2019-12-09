package dev.hyperlisk.nintanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import dev.hyperlisk.nintanks.Reference.;
public class InputHandler {

    public void update(float dt) {

        if(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            Directions.UP_DIR = true;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx)


    }

}
