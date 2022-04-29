package java8.date;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {

    public static void main(String[] args) {


        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println("zone : "+ zonedDateTime.getZone());
        System.out.println("zone offset : "+zonedDateTime.getOffset());

        System.out.println("available zones : "+ZoneId.getAvailableZoneIds()
                .stream()
                .count());


        System.out.println("PST time now : "+ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));

    }
}
