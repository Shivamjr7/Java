package parser;

import java.time.Duration;
import java.time.Instant;

public class FindTimeElapse {


    public static void main(String[] args) {


//        Instant start = Instant.now();
//        loop();
//        Instant end = Instant.now();

        long start = System.currentTimeMillis();

        loop();

        long end = System.currentTimeMillis();
        System.out.println(end-start);


        long startTime = System.nanoTime();
        loop();
        long endTime = System.nanoTime();

        long diff = endTime - startTime;
        double lat = (double) diff / 1_000_000;
        System.out.println(lat);


//        Duration timeElapsed = Duration.between(start, end);
//        System.out.println(timeElapsed.getSeconds());
    }


    static void loop()
    {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
