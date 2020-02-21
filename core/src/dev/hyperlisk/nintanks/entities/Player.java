package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import dev.hyperlisk.nintanks.util.MapHandler;
import dev.hyperlisk.nintanks.util.Reference.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Player {

    private Sprite playerSprite;
    private Sprite mouseSprite;

    private Vector2 playerPos = new Vector2(200, 200);
    private Vector2 direction = new Vector2(0, 0);

    private float angle;

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


        // Sets position of the cross hair sprite to where the mouse is on the screen.
        mouseSprite.setPosition(Mouse.mousePosition.x - mouseSprite.getOriginX(), Gdx.graphics.getHeight() - Mouse.mousePosition.y - mouseSprite.getOriginY());
        playerSprite.setRotation((float) Math.toDegrees(calcAngle(playerPos, Mouse.mousePosition)));

        playerSprite.setPosition(playerPos.x, playerPos.y);
    }


    /**
     *  Renders the sprite to the screen. 
     * @param sb
     */
    public void render(SpriteBatch sb) {
        sb.begin();



        // Draw the sprites.
        mouseSprite.draw(sb);
        playerSprite.draw(sb);

        sb.end();
    }

    /**
     * Rotate the player sprite based on where the mouse is.
     *
     *
     */
    public double calcAngle(Vector2 PlayerPos, Vector2 MousePos) {

        double adjacent = (MousePos.x - PlayerPos.x);
        double opposite = (PlayerPos.y - MousePos.y);

        double h = Math.atan2(opposite, adjacent);

        return -h;

    }


    /**
     * Takes in a single wall and returns its distance as an int.
     * @param w
     * @return distance from player
     */
    public int getDistanceFromWall(Wall w) {
        // Distance from a single wall.
        return (int)Math.abs(new Point((int)playerPos.x, (int)playerPos.y).distance(w.getAsPoint()));
    }


    /**
     * Returns all walls within a given distance to the player.
     * This is done to save processing power.
     * @param radius
     * @return an array of walls that are close to the player.
     */
    public Wall[] getNearbyWalls(double radius) {

        // Sort nearby walls
        ArrayList<Wall> sorted = new ArrayList<>(MapHandler.getInstance().getWalls());

        // Sort with a comparator.
        sorted.sort(Comparator.comparing(this::getDistanceFromWall));

        // Get all walls within radius
        int lastWallInRaduis = sorted.size() - 1;

        // For each wall in the array if the wall is outside the radius.
        for(int i = 0; i < sorted.size(); i++){

            // Break out of the loop if we find a wall outside radius
            if(getDistanceFromWall(sorted.get(i)) > radius){
                break;
            }
            // Set the farthest wall index
            lastWallInRaduis = i;
        }
        return sorted.subList(0, lastWallInRaduis).toArray(new Wall[lastWallInRaduis + 1]);
    }


    // ********* Getters and Setters ********* \\

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(float x, float y) {

        this.direction = new Vector2(x, y);

    }

    public Vector2 getPosition() {
        return playerPos;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getAngle() {
        return this.angle;
    }

}
