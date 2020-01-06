package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class HelpMethods {

    //Create random int in range.
    public static int getRandomValueInRange(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}
