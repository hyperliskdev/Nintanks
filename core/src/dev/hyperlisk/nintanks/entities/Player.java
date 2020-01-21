package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import dev.hyperlisk.nintanks.Nintanks;
import dev.hyperlisk.nintanks.helpers.MathHelper;
import dev.hyperlisk.nintanks.util.MapHandler;
import dev.hyperlisk.nintanks.util.Reference.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

import static dev.hyperlisk.nintanks.util.Reference.VIEWPORT_HEIGHT;
import static dev.hyperlisk.nintanks.util.Reference.VIEWPORT_WIDTH;

public class Player {

    private Sprite playerSprite;

    private Vector2 playerPos = new Vector2(200, 100);
    private Vector2 direction = new Vector2(0, 0);

    private float playerScale = 1.0f;
    private float angle;

    private Rectangle collider;

    private Sprite mouseSprite;

    private ArrayList<Bullet> bullets = new ArrayList<>();

    /**
     * Constuctor for the player.
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
        collide();
        move();

        bullets.removeIf(n -> (bullets.get(0).getX() > VIEWPORT_WIDTH));
        bullets.removeIf(n -> (bullets.get(0).getY() > VIEWPORT_HEIGHT));


        bullets.removeIf(n -> (bullets.get(0).getX() < 0));
        bullets.removeIf(n -> (bullets.get(0).getY() < 0));

        for (Bullet b: bullets) {
            b.update(dt);

        }

        if(UtilKeys.SHOOT_KEY) {
            if(bullets.size() > 1) {
                return;
            }
            shoot();
        }
    }

    public void move() {

        if(Directions.UP_DIR) {

            playerPos.x -= getDirection().x;
            playerPos.y -= getDirection().y;
        }

        if(Directions.DOWN_DIR) {

            playerPos.x += getDirection().x;
            playerPos.y += getDirection().y;

        }

        playerSprite.setPosition(playerPos.x, playerPos.y);
        collider.setPosition(playerPos.x, playerPos.y);
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

        for (Bullet b: bullets) {
            b.render(sb);
        }

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
        setDirection(new Vector2((float) Math.cos(Math.toRadians(angle + 180)), (float) Math.sin(Math.toRadians(angle + 180))));

        if(angle < 0){
            angle += 360;
        }
    }

    /**
     * Move's the player backwards 2x the negative of its current distance away from any nearby walls it is overlaping.
     *
     */
    public void collide() {
        double radius = 100;
        Wall[] walls;

        if(getNearbyWalls(radius) == null || getNearbyWalls(radius).length <= 1) {
            return;
        } else {
            Wall currentWall;
            walls = getNearbyWalls(radius);
            for (int i = 0; i < walls.length; i++) {
                currentWall = walls[i];

                if(currentWall.getWallRect().overlaps(collider)) {

                    setDirection(new Vector2(-getDirection().x * 2, -getDirection().y * 2));
                    move();
                }
               return;
            }
        }

    }

    /**
     * Function that allows the player to shoot a bullet.
     *
     */
    public void shoot() {
        Bullet bullet = new Bullet();
        bullet.setDirection(getDirection().x, getDirection().y);
        bullet.setPosition(playerPos.x, playerPos.y);
        bullets.add(bullet);


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



    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }


}
