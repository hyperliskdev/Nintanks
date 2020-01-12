package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import dev.hyperlisk.nintanks.Nintanks;
import dev.hyperlisk.nintanks.util.Reference.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Player {

    // Player values
    private Sprite playerSprite;

    private Vector2 playerPos = new Vector2(200, 100);
    private Vector2 direction = new Vector2(0, 0);
    private Vector2 velocity = new Vector2(1, 1);

    private float playerScale = 1.0f;
    private float angle;

    private Rectangle collider;

    // Mouse values
    private Sprite mouseSprite;

    /**
     *
     */
    public Player() {

        // Initialize Sprites
        playerSprite = new Sprite(new Texture("player/player_tank_blue.png"));
        mouseSprite = new Sprite(new Texture("item/crosshair.png"));

        // Scale Sprites
        playerSprite.scale(this.playerScale);
        mouseSprite.scale(0.5f);

        // Set origins to accurate positioning
        playerSprite.setOrigin(playerSprite.getOriginX() + 1.5f, playerSprite.getOriginY());
        mouseSprite.setOrigin(mouseSprite.getWidth() / 2, mouseSprite.getHeight() / 2);

        // Bounding box initialization
        collider = new Rectangle(0, 0, playerSprite.getWidth(), playerSprite.getHeight());

    }

    /**
     *
     * @param dt
     */
    public void update(float dt) {

        mouseSprite.setPosition(Mouse.mousePosition.x - mouseSprite.getOriginX(), Gdx.graphics.getHeight() - Mouse.mousePosition.y - mouseSprite.getOriginY());

        rotateSprite();

        setDirection(new Vector2((float) Math.cos(Math.toRadians(angle + 180)), (float) Math.sin(Math.toRadians(angle + 180))));

        collide();

        if(Directions.UP_DIR) {

            playerPos.x -= getDirection().x * getVelocity().x;
            playerPos.y -= getDirection().y * getVelocity().y;
        }

        if(Directions.DOWN_DIR) {

            playerPos.x += getDirection().x;
            playerPos.y += getDirection().y;

        }

        collider.setPosition(playerPos.x, playerPos.y);
        playerSprite.setPosition(collider.x, collider.y);

    }

    /**
     *
     * @param sb
     */
    public void render(SpriteBatch sb) {
        sb.begin();
        playerSprite.setRotation(angle + 180);

        // Draw the sprites.
        mouseSprite.draw(sb);
        playerSprite.draw(sb);
        sb.end();
    }

    /** Rotate the player sprite based on where the mouse is.
     *
     */
    public void rotateSprite() {

        float xInput = Mouse.mousePosition.x;
        float yInput = (Gdx.graphics.getHeight() - Mouse.mousePosition.y);

        // Get the angle based on the mouse position.
        this.angle = MathUtils.radiansToDegrees * MathUtils.atan2(yInput - playerPos.y, xInput - playerPos.x);

        if(angle < 0){
            angle += 360;
        }
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
     *
     * @param radius
     * @return
     */
    public Wall[] getNearbyWalls(double radius) {

        // Sort nearby walls
        ArrayList<Wall> sorted = new ArrayList<>(Nintanks.getInstance().mapHandler.getWalls());
        sorted.sort(Comparator.comparing(this::getDistanceFromWall));

        // Get all walls within radius
        int lastWallInRaduis = sorted.size() - 1;

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

    /**
     *
     */
    public void collide() {
        double radius = 100;
        Wall[] walls;

        if(getNearbyWalls(radius) == null || getNearbyWalls(radius).length <= 1) {
            return;
        } else {
            walls = getNearbyWalls(radius);
        }


        for (int i = 0; i < walls.length; i++) {

            if(walls[i].getWallRect().overlaps(collider)) {

                

            }



            }
        }


    public Vector2 getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(Vector2 playerPos) {
        this.playerPos = playerPos;
    }

    public void setPlayerX(float x) {
        this.playerPos.x = x;
    }

    public void setPlayerY(float y) {
        this.playerPos.y = y;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

    public float getPlayerScale() {
        return playerScale;
    }

    public void setPlayerScale(float playerScale) {
        this.playerScale = playerScale;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public Rectangle getCollider() {
        return collider;
    }

    public void setCollider(Rectangle collider) {
        this.collider = collider;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
