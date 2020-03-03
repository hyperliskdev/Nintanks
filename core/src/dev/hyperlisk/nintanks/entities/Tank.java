package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.hyperlisk.nintanks.util.Reference.Directions;;


public class Tank {

    private TankType tankType;
    private Movement movement;
    private Behavior behavior;
    private BulletSpeed bulletSpeed;
    private FireRate fireRate;

    private Player pl;
    private Sprite sprite;

    private float x, y;
    private double rotation;
    private double speed;

    public Tank(TankType type, float x, float y, Player player) {

        this.x = x;
        this.y = y;
        this.tankType = type;
        pl = player;


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

        sprite = tankType.getSprite();
        speed = movement.getSpeed();
       
    }


    public void update(float dt) {

    }


    public void render(SpriteBatch sb) {

        sb.begin();

        sprite.draw(sb);

        sb.end();

    }

    /**
     * Enum defines which sprite to draw on the screen.
     *
     */
    public enum TankType {

        BROWN(new Sprite(new Texture("enemy/enemy_tank_brown.png"))),
        GREY(new Sprite(new Texture("enemy/enemy_tank_grey.png"))),
        TEAL(new Sprite(new Texture("enemy/enemy_tank_teal.png"))),
        YELLOW(new Sprite(new Texture("enemy/enemy_tank_yellow.png"))),
        PINK(new Sprite(new Texture("enemy/enemy_tank_pink.png"))),
        GREEN(new Sprite(new Texture("enemy/enemy_tank_green.png"))),
        PURPLE(new Sprite(new Texture("enemy/enemy_tank_purple.png"))),
        WHITE(new Sprite(new Texture("enemy/enemy_tank_white.png"))),
        BLACK(new Sprite(new Texture("enemy/enemy_tank_black.png")));

        public Sprite sprite;

        public Sprite getSprite() {

            return this.sprite;

        }

        private TankType(Sprite sprite) {
            this.sprite = sprite;
        }
    }

    private enum Movement {

        STATIONARY(0),
        NORMAL(3),
        FAST(5),
        SLOW(1);

        public int speed;

        public int getSpeed() {
            return this.speed;
        }

        private Movement(int speed) {
            this.speed = speed;
        }

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

    public double getY() {
        return y;
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
