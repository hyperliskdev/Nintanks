package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {

    private Rectangle bulletRect;
    private Sprite bulletSprite;
    private Vector2 position;
    private float rotation;
    private Vector2 direction;

    public Bullet() {
        bulletSprite = new Sprite(new Texture("item/bullet.png"));
        bulletRect = bulletSprite.getBoundingRectangle();
    }

    public void update(float dt) {
        position.x -= direction.x * 2;
        position.y -= direction.y * 2;
        bulletSprite.setPosition(position.x, position.y);

    }

    public void render(SpriteBatch sb) {
        bulletSprite.draw(sb);
    }

    public void setDirection(float dirx, float diry) {
        this.direction = new Vector2(dirx, diry);
    }

    public void setPosition(float x, float y) {
        position = new Vector2(x, y);
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
