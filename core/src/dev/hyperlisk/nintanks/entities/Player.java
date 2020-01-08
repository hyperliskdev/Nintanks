package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import dev.hyperlisk.nintanks.util.Reference.*;

public class Player {

    private float xpos, ypos;
    private float velx, vely;

    private float deltaX, deltaY;
    private float speed = 1.2f;

    private Rectangle collider;

    private float angle;
    private final float ACCELERATION = 0.2f, MAX_SPEED = 2;

    private Sprite sprite;
    private Sprite mouseSprite;

    public Player() {

        // Initialize Sprites
        sprite = new Sprite(new Texture("player/player_tank_blue.png"));
        mouseSprite = new Sprite(new Texture("item/crosshair.png"));

        // Scale Sprites
        sprite.scale(1);
        mouseSprite.scale(0.5f);

        // Set origins to accurate positioning
        sprite.setOrigin(sprite.getOriginX() + 1.5f, sprite.getOriginY());
        mouseSprite.setOrigin(mouseSprite.getWidth() / 2, mouseSprite.getHeight() / 2);

        // Bounding box initialization
        collider = sprite.getBoundingRectangle();

        sprite.setPosition(200, 200);
    }


    public void update(float dt) {

        mouseSprite.setPosition(Mouse.mousePosition.x - mouseSprite.getOriginX(), Gdx.graphics.getHeight() - Mouse.mousePosition.y - mouseSprite.getOriginY());

        deltaX = (float) Math.cos(Math.toRadians(angle + 180));
        deltaY = (float) Math.sin(Math.toRadians(angle + 180));

        rotateSprite();

        if(Directions.UP_DIR) {

            xpos -= deltaX * speed;
            ypos -= deltaY * speed;

        }

        if(Directions.DOWN_DIR) {

            xpos += deltaX * speed;
            ypos += deltaY * speed;

        }

        sprite.setX(xpos);
        sprite.setY(ypos);
        collider.setPosition(xpos, ypos);
    }

    public void render(SpriteBatch sb) {
        sb.begin();

        sprite.setRotation(angle + 180);


        mouseSprite.draw(sb);
        sprite.draw(sb);
        sb.end();
    }

    public void rotateSprite() {

        float xInput = Mouse.mousePosition.x;
        float yInput = (Gdx.graphics.getHeight() - Mouse.mousePosition.y);

        angle = MathUtils.radiansToDegrees * MathUtils.atan2(yInput - ypos, xInput - xpos);


        if(angle < 0){
            angle += 360;
        }
    }

    public void collide(Rectangle wallRect, float radius) {

        if(collider.overlaps(wallRect)) {
            speed = 0.2f;
        } else {
            speed = 1.2f;
        }

    }

}
