package utils;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();


    public static int getRandomIntInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return random.nextInt((max - min) + 1) + min;
    }
}
