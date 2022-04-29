package java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateTimeExample {


    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("local date :"+ localDate);


        LocalTime localtime  = LocalTime.now();
        System.out.println("local time : "+ localtime);

        LocalDateTime  localDateTime = LocalDateTime.now();
        System.out.println("local date and time : "+ localDateTime);

    }
}
