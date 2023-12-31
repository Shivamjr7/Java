import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantTime {

    public static void main(String[] args) {

        String testtime = Instant.ofEpochMilli(1692002809069L).toString();

        Instant checkTime = null;
//        checkTime = Instant.ofEpochMilli(1690923850082L).plusSeconds(1690927450);
//        System.out.println(checkTime.toString());
//        String testtime = checkTime.toString();

        Instant instant1 = Instant.parse(testtime);

        ZoneId desiredZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime pstDateTime = instant1.atZone(desiredZone);

        System.out.println("PRINTING the TIME in PST: " + pstDateTime);


//        System.out.println(checkTime.toString());
    }
}
