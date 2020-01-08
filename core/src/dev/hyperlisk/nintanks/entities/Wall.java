package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static dev.hyperlisk.nintanks.util.Reference.*;

public class Wall{

    private float x, y;
    private float scale;
    private boolean breakable;
    private Sprite wall;

    public Wall(int x, int y, boolean breakable) {
        this.x = (float) x;
        this.y = (float) y;

        if(breakable) {
            wall = new Sprite(new Texture("wall/wall_cracked.png"));
        } else {
            wall = new Sprite(new Texture("wall/wall_normal.png"));
        }

//        wall.setOrigin(wall.getWidth() / 2, wall.getHeight() / 2);
    }

    public void update(float dt) {


        wall.setX( TILESIZEX* x);
        wall.setY(TILESIZEY * y);

    }

    public void render(SpriteBatch sb) {
        sb.begin();

        wall.draw(sb);

        sb.end();
    }

    public void collide() {

    }


}
