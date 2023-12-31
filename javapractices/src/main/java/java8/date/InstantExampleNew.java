package java8.date;

import java.time.Instant;

public class InstantExampleNew {

    public static void main(String[] args) {
        Instant instant = null;

//        instant = Instant.ofEpochMilli(100L);
        System.out.println(instant);

        System.out.println(isEligibleToPick(instant));

    }
    private static  boolean isEligibleToPick( Instant pickupTimeForRuleApp) {
        return (null!= pickupTimeForRuleApp && Instant.now().isAfter(pickupTimeForRuleApp) || Instant.now().equals(pickupTimeForRuleApp));
    }
}
