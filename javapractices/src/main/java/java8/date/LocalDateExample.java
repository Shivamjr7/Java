package java8.date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {


    public static void main(String[] args) {


        LocalDate date = LocalDate.now();
        System.out.println("Date now : "+ date);


        LocalDate date1 = LocalDate.of(2022,03,20);
        System.out.println("date 1 : "+ date1);

        LocalDate date2 = LocalDate.ofYearDay(2020,365);
        System.out.println("from year day : " + date2);


        /**
         * getting the values now
         */

        System.out.println("month "+date2.getMonth());
        System.out.println("month value : "+ date2.getMonthValue());
        System.out.println("day of the year "+ date2.getDayOfYear());
        System.out.println("day of the month "+ date2.getDayOfMonth());
        System.out.println("day of the week "+ date2.getDayOfWeek());


        /**
         * modify the localdate
         */
        System.out.println("add 1 day : "+date2.plusDays(1));
        System.out.println("add 1 month : "+ date2.plusMonths(1));
        System.out.println("minus 2 days : "+ date2.minusDays(2));
        System.out.println("change year "+ date2.withYear(2011));
        System.out.println("temporal adjusters : "+ date2.with(TemporalAdjusters.firstDayOfNextMonth()));
    }
}
