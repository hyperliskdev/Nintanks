package dev.hyperlisk.nintanks.util;

import com.badlogic.gdx.math.Vector2;

public class Reference {

    public static final int VIEWPORT_WIDTH = 768;
    public static final int VIEWPORT_HEIGHT = 768;

    public static class Directions {

        public static boolean UP_DIR;
        public static boolean DOWN_DIR;
        public static boolean LEFT_DIR;
        public static boolean RIGHT_DIR;

        public static boolean FORWARD_DIR;
        public static boolean BACKWARD_DIR;

        public static boolean SHIFT;

    }

    public static class UtilKeys {

        public static boolean SHOOT_KEY;

    }
    public static class Mouse {
        public static Vector2 mousePosition = Vector2.Zero;

        public static boolean isDragged;
        public static boolean mouseLeft;
        public static boolean mouseRight;
        public static boolean mouseMiddle;

    }

    public static class Player {

        public static float ACCELERATION = 1.0f;

    }


}
