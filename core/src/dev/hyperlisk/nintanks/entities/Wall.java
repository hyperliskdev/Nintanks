package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static dev.hyperlisk.nintanks.util.Reference.*;

public class Wall {

    private Vector2 wallPos = new Vector2(0,0);
    private float scale = 0.5f;
    private boolean breakable;
    private Sprite wall;
    private Rectangle wallRect;

    public Wall(int x, int y, boolean breakable) {
        wallPos.x = y;
        wallPos.y = x;

        if(breakable) {
            wall = new Sprite(new Texture("wall/wall_cracked.png"));
        } else {
            wall = new Sprite(new Texture("wall/wall_normal.png"));
        }

        wall.scale(scale);

        wall.setOrigin(wall.getWidth() / 2 - 10, wall.getHeight() / 2 );

        wall.setX((VIEWPORT_WIDTH / wall.getWidth() * wallPos.x) / 2);
        wall.setY((VIEWPORT_HEIGHT / wall.getHeight() * wallPos.y) / 2);

    }

    public void update(float dt) {

    }

    public void render(SpriteBatch sb) {
        sb.begin();

        wall.draw(sb);

        sb.end();
    }

    public Rectangle getWallRect() {
        return wallRect;
    }


}
