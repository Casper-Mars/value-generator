package org.r.generator.value.tool;

import java.util.Random;

public class UtilTool {



    public static Integer getRandomInteger(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static Long getRandomLong() {
        Random random = new Random();
        return random.nextLong();
    }


}
