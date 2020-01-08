package dev.hyperlisk.nintanks;

import com.badlogic.gdx.Input.*;

import com.badlogic.gdx.InputProcessor;
import dev.hyperlisk.nintanks.Reference.*;


public class InputHandler implements InputProcessor {

    public InputHandler() {}

    @Override
    public boolean keyDown(int keycode) {

        boolean keyProcessed = false;
        switch (keycode)
        {
            case Keys.LEFT: case Keys.A:
                Directions.LEFT_DIR = true;
                keyProcessed = true;
                break;
            case Keys.RIGHT: case Keys.D:
                Directions.RIGHT_DIR = true;
                keyProcessed = true;
                break;
            case Keys.UP: case Keys.W:
                Directions.UP_DIR = true;
                keyProcessed = true;
                break;
            case Keys.DOWN: case Keys.S:
                Directions.DOWN_DIR = true;
                keyProcessed = true;
        }
        return keyProcessed;
    }

    @Override
    public boolean keyUp(int keycode) {
        boolean keyProcessed = false;
        switch (keycode)
        {
            case Keys.LEFT: case Keys.A:
                Directions.LEFT_DIR = false;
                keyProcessed = true;
                break;
            case Keys.RIGHT: case Keys.D:
                Directions.RIGHT_DIR = false;
                keyProcessed = true;
                break;
            case Keys.UP: case Keys.W:
                Directions.UP_DIR = false;
                keyProcessed = true;
                break;
            case Keys.DOWN: case Keys.S:
                Directions.DOWN_DIR = false;
                keyProcessed = true;
        }
        return keyProcessed;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Mouse.isDragged = false;
        switch (button) {
            case 1:
                Mouse.mouseLeft = true;
                break;
            case 2:
                Mouse.mouseRight = true;
                break;
            case 3:
                Mouse.mouseMiddle = true;
                break;
        }
        Mouse.mousePosition.x = screenX;
        Mouse.mousePosition.y = screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Mouse.isDragged = false;
        switch (button) {
            case 1:
                Mouse.mouseLeft = false;
                break;
            case 2:
                Mouse.mouseRight = false;
                break;
            case 3:
                Mouse.mouseMiddle = false;
                break;
        }
        Mouse.mousePosition.x = screenX;
        Mouse.mousePosition.y = screenY;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Mouse.mousePosition.x = screenX;
        Mouse.mousePosition.y = screenY;
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
