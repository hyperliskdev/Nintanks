package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import dev.hyperlisk.nintanks.Reference.*;

import java.sql.Ref;

import static dev.hyperlisk.nintanks.Reference.VIEWPORT_HEIGHT;
import static dev.hyperlisk.nintanks.Reference.VIEWPORT_WIDTH;

public class Player {

    private float xpos, ypos;
    private float velx, vely;

    private float deltaX, deltaY;
    private float speed = 1.2f;

    private float angle;
    private final float ACCELERATION = 0.2f, MAX_SPEED = 2;

    private Sprite sprite;
    private Sprite mouseSprite;

    public Player() {
        sprite = new Sprite(new Texture("player/player_tank_blue.png"));
        mouseSprite = new Sprite(new Texture("item/crosshair.png"));
        sprite.scale(1);
        sprite.setOrigin(sprite.getOriginX() + 1.5f, sprite.getOriginY());
        mouseSprite.scale(0.5f);

    }


    public void update(float dt) {

        mouseSprite.setPosition(Gdx.input.getX() - 6, -Gdx.input.getY() + Gdx.graphics.getHeight() - 10);

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

}
