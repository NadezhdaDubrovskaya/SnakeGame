package com.rmw.snake;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();

    static int getRandomNumberInRange(final int min, final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
