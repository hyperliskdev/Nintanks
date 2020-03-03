package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import dev.hyperlisk.nintanks.util.Reference.*;


public class Player {

    private Sprite playerSprite;
    private Sprite mouseSprite;

    private Vector2 playerPosition = new Vector2(50, 50);
    private Vector2 playerVelocity;
    /**
     * Constuctor for the player.
     */
    public Player() {

        // Initialize Sprites
        playerSprite = new Sprite(new Texture("player/player_tank_blue.png"));
        mouseSprite = new Sprite(new Texture("item/crosshair.png"));

    }

    /**
     * Updates values within classes.
     *
     * @param dt
     */
    public void update(float dt) {

        playerSprite.setPosition(playerPosition.x, playerPosition.y);

        playerSprite.setRotation(calcAngle());

    }


    /**
     *  Renders the sprite to the screen. 
     * @param sb
     */
    public void render(SpriteBatch sb) {
        sb.begin();



        playerSprite.draw(sb);
        sb.end();
    }

    /**
     * Calculating the angle between the player and the mouse.
     * MATH!
     * @return playerAngle
     */
    public float calcAngle() {

        float playerAngle;


        playerAngle = (float) Math.toDegrees(Math.atan2((Gdx.graphics.getHeight() - Mouse.mousePosition.y) - playerPosition.y, Mouse.mousePosition.x - playerPosition.x));

        if(playerAngle < 0) {
            playerAngle = playerAngle + 360;
        }

        // Account for the rotated sprite image.
        playerAngle = playerAngle + 180;

        return playerAngle;

    }



}
