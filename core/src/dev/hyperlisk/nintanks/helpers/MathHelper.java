package dev.hyperlisk.nintanks.helpers;

public class MathHelper {

    public static double clamp(double value, double low, double high) {
        return Math.max(low, Math.min(value, high));
    }

}
