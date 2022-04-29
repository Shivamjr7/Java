package java8.date;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {


    public static void main(String[] args) {


        Instant instant1 = Instant.now();


        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Instant instant2 = Instant.now();


        Duration duration = Duration.between(instant1,instant2);
        System.out.println("duration in milliseconds : " + duration.toMillis());


    }
}
