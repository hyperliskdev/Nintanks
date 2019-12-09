package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.Viewport;

import static dev.hyperlisk.nintanks.Reference.VIEWPORT_HEIGHT;
import static dev.hyperlisk.nintanks.Reference.VIEWPORT_WIDTH;

public class Player {

    private float x, y;
    private Texture tex;

    public Player() {
        x = VIEWPORT_WIDTH / 2;
        y = VIEWPORT_HEIGHT / 2;

        loadPlayerTextures();

    }

    public void loadPlayerTextures() {

        tex = new Texture("index.png");

    }

    public void update(float dt) {

    }

    public void render(SpriteBatch sb) {
        sb.draw(tex, x, y);
    }
}
