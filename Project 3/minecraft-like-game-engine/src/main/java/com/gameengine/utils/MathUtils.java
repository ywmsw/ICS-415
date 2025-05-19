package com.gameengine.utils;

public class MathUtils {
    public static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }

    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static float randomRange(float min, float max) {
        return min + (float) Math.random() * (max - min);
    }

    public static double distance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static float[] normalize(float[] vector) {
        float length = (float) Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1]);
        if (length == 0) return new float[]{0, 0};
        return new float[]{vector[0] / length, vector[1] / length};
    }
}