package dev.hyperlisk.nintanks.util;

import com.badlogic.gdx.math.Vector2;

public class Reference {

    public static final int VIEWPORT_WIDTH = 800;
    public static final int VIEWPORT_HEIGHT = 600;

    public static final int TILESIZEX = VIEWPORT_WIDTH / 16;
    public static final int TILESIZEY = VIEWPORT_HEIGHT / 16;

    public static class Directions {

        public static boolean UP_DIR;
        public static boolean DOWN_DIR;
        public static boolean LEFT_DIR;
        public static boolean RIGHT_DIR;

        public static boolean FORWARD_DIR;
        public static boolean BACKWARD_DIR;

    }

    public static class Mouse {
        public static Vector2 mousePosition = Vector2.Zero;

        public static boolean isDragged;
        public static boolean mouseLeft;
        public static boolean mouseRight;
        public static boolean mouseMiddle;

    }


}
