package dev.hyperlisk.nintanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.*;

import dev.hyperlisk.nintanks.Reference.*;
public class InputHandler {

    public void update(float dt) {

        if(Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) {
            Directions.UP_DIR = true;
        }

        if(Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)) {

            Directions.DOWN_DIR = true;

        }

        if(Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {

            Directions.LEFT_DIR = true;

        }

    }

}
