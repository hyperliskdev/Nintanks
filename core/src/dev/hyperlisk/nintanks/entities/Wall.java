package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

import static dev.hyperlisk.nintanks.util.Reference.*;

public class Wall {

    // Movement vector
    private Vector2 wallPos = new Vector2(0,0);

    // Scale the image by this amount.
    private float scale = 0.5f;

    // Is the wall breakable?
    private boolean breakable;

    // Sprite and collision rectangle
    private Sprite wall;
    private Rectangle wallRect;

    public Wall(int x, int y, boolean breakable) {
        wallPos.x = y;
        wallPos.y = x;
        this.breakable = breakable;

        // Detect weather or not it is a breakable wall, change the texture accordingly.
        if(this.breakable) {
            wall = new Sprite(new Texture("wall/wall_cracked.png"));
        } else {
            wall = new Sprite(new Texture("wall/wall_normal.png"));
        }

        // Scale the image so that its correctly sized.
        wall.scale(scale);

        // Change the origin/ make sure it is at the center of the image.
        wall.setOrigin(wall.getWidth() / 2 - 10, wall.getHeight() / 2 );

        // Set placement based on MapHandler directions.
        wall.setX((VIEWPORT_WIDTH / wall.getWidth() * wallPos.x) / 2);
        wall.setY((VIEWPORT_HEIGHT / wall.getHeight() * wallPos.y) / 2);

        wallRect = new Rectangle(wall.getBoundingRectangle());

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

    public Point getAsPoint() {

        return new Point((int)(VIEWPORT_WIDTH / wall.getWidth() * wallPos.x) / 2, (int)(VIEWPORT_HEIGHT / wall.getHeight() * wallPos.y) / 2 );

    }

}
