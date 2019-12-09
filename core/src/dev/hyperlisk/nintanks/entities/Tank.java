package dev.hyperlisk.nintanks.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import dev.hyperlisk.nintanks.entities.ai.IDumbDefensive;
import dev.hyperlisk.nintanks.entities.ai.IDumbOffensive;
import dev.hyperlisk.nintanks.entities.ai.ISmartDefensive;
import dev.hyperlisk.nintanks.entities.ai.ISmartOffensive;

public class Tank implements IDumbDefensive, IDumbOffensive, ISmartOffensive, ISmartDefensive {

    private TankType type;
    private Sprite sprite;
    private double x, y;

    public Tank() {

    }

    public enum TankType {
        BROWN,
        GREY,
        TEAL,
        YELLOW,
        PINK,
        GREEN,
        PURPLE,
        WHITE,

    }

    public void move() {
        // Based on what values are given

    }

    public void shoot() {


    }
    public TankType getType() {
        return type;
    }

    public void setType(TankType type) {
        this.type = type;
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
}
