package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.Viewport;
import dev.hyperlisk.nintanks.Reference.*;

import java.sql.Ref;

import static dev.hyperlisk.nintanks.Reference.VIEWPORT_HEIGHT;
import static dev.hyperlisk.nintanks.Reference.VIEWPORT_WIDTH;

public class Player {

    private float x, y;
    private Texture tex;
    private Sprite sprite;

    public Player() {
        loadPlayerTextures();

        x = tex.getWidth() / 2;
        y = tex.getHeight() / 2;


    }

    public void loadPlayerTextures() {

        tex = new Texture("index.png");


    }

    public void update(float dt) {

        if (Directions.UP_DIR) {
            y += 5;
            Directions.UP_DIR = false;
        }
        if (Directions.DOWN_DIR) {
            y -= 5;
            Directions.DOWN_DIR = false;
        }
        if (Directions.LEFT_DIR) {
            x -= 5;
            Directions.LEFT_DIR = false;
        }
        if (Directions.RIGHT_DIR) {
            x += 5;
            Directions.RIGHT_DIR = false;
        }

    }

    public void render(SpriteBatch sb) {
        sb.draw(tex, x, y);
    }
}
