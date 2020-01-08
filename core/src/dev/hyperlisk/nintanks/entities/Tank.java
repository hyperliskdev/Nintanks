package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import dev.hyperlisk.nintanks.entities.ai.TankAI;

public class Tank {

    private TankType tankType;
    private Movement movement;
    private Behavior behavior;
    private BulletSpeed bulletSpeed;
    private FireRate fireRate;

    private Sprite sprite;
    private Texture texture;

    private double x, y;
    private double rotation;
    private double speed;

    public Tank(TankType type) {

        // Setup all behavior enums for what the tank should do.
        switch (tankType) {

            case BROWN:
                movement = Movement.STATIONARY;
                behavior = Behavior.PASSIVE;
                bulletSpeed = BulletSpeed.NORMAL;
                fireRate = FireRate.SLOW;
            case GREY:
                movement = Movement.SLOW;
                behavior = Behavior.DEFENSIVE;
                bulletSpeed = BulletSpeed.NORMAL;
                fireRate = FireRate.SLOW;
            case TEAL:
                movement = Movement.SLOW;
                behavior = Behavior.DEFENSIVE;
                bulletSpeed = BulletSpeed.FAST;
                fireRate = FireRate.SLOW;
            case YELLOW:
                movement = Movement.NORMAL;
                behavior = Behavior.OFFENSIVE;
                bulletSpeed = BulletSpeed.NORMAL;
                fireRate = FireRate.SLOW;
            case PINK:
                movement = Movement.SLOW;
                behavior = Behavior.OFFENSIVE;
                bulletSpeed = BulletSpeed.NORMAL;
                fireRate = FireRate.FAST;
            case GREEN:
                movement = Movement.STATIONARY;
                behavior = Behavior.ADVANCED;
                bulletSpeed = BulletSpeed.FAST;
                fireRate = FireRate.FAST;
            case PURPLE:
                movement = Movement.NORMAL;
                behavior = Behavior.OFFENSIVE;
                bulletSpeed = BulletSpeed.NORMAL;
                fireRate = FireRate.FAST;
            case WHITE:
                movement = Movement.SLOW;
                behavior = Behavior.OFFENSIVE;
                bulletSpeed = BulletSpeed.NORMAL;
                fireRate = FireRate.FAST;
            case BLACK:
                movement = Movement.FAST;
                behavior = Behavior.OFFENSIVE;
                bulletSpeed = BulletSpeed.FAST;
                fireRate = FireRate.FAST;



        }


    }


    public void update(float dt) {

    }

    public void render() {

        switch (tankType) {

            case BROWN:

            case GREY:

            case TEAL:

            case YELLOW:

            case PINK:

            case PURPLE:

            case GREEN:

            case WHITE:

            case BLACK:
        }

    }

    private enum TankType {
        BROWN,
        GREY,
        TEAL,
        YELLOW,
        PINK,
        GREEN,
        PURPLE,
        WHITE,
        BLACK

    }

    private enum Movement {
        STATIONARY,
        NORMAL,
        FAST,
        SLOW
    }

    private enum Behavior {

        PASSIVE,
        DEFENSIVE,
        OFFENSIVE,
        ADVANCED

    }

    private enum BulletSpeed {
        NORMAL,
        FAST
    }

    private enum FireRate {

        SLOW,
        FAST

    }

    public void move() {
        // Based on what values are given



    }

    public void shoot() {


    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public TankType getType() {
        return tankType;
    }

    public void setType(TankType type) {
        this.tankType = type;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public TankType getTankType() {
        return tankType;
    }

    public Movement getMovement() {
        return movement;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public BulletSpeed getBulletSpeed() {
        return bulletSpeed;
    }


    public FireRate getFireRate() {
        return fireRate;
    }

    public double getSpeed() {
        return speed;
    }

}
