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

    private float xvel, yvel;
    private float xpos, ypos;
    private float time;
    private Vector2 vec = new Vector2(0,0);

    private float angle;
    private final float FRICTION = 0.5f, ACCELERATION = 0.5f;

    private Sprite sprite;

    public Player() {
        sprite = new Sprite(new Texture("player/player_tank_blue.png"));

    }


    public void update(float dt) {
        time += dt;
        xpos = sprite.getX();
        ypos = sprite.getY();
        float yInput = (Gdx.graphics.getHeight() - Gdx.input.getY());

        vec.set(Gdx.input.getX() - xpos, yInput - ypos).nor();

        xpos = 50;
        ypos = 50;


        System.out.println(angle);

        if(Directions.DOWN_DIR) {

        }
        if(Directions.UP_DIR) {

        }

        if(Directions.RIGHT_DIR) {

        }

        if(Directions.LEFT_DIR) {


        }

        sprite.setRotation(angle);

    }

    public void render(SpriteBatch sb) {
        sb.begin();

        sprite.setPosition(xpos - sprite.getWidth()/2, ypos - sprite.getHeight()/2);

        float xInput = Gdx.input.getX();
        float yInput = (Gdx.graphics.getHeight() - Gdx.input.getY());

        float angle = MathUtils.radiansToDegrees * MathUtils.atan2(yInput - ypos, xInput - xpos);

        if(angle < 0){
            angle += 360;
        }
        sprite.rotate(angle + 180);


        sprite.draw(sb);
        sb.end();
    }
}
