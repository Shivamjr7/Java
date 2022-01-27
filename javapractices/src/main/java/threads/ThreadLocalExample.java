package threads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample {


    public static void main(String[] args) throws ParseException {
        String birthDate = "1991-04-08";
        //this will create a object for a specific/each thread
        final SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.sdf.get();

        Date parse = simpleDateFormat.parse(birthDate);

        System.out.println("Date : "+ parse);
    }
}


class ThreadSafeFormatter{

   public static ThreadLocal<SimpleDateFormat> sdf  = ThreadLocal.withInitial(
            ()-> new SimpleDateFormat("yyyy-MM-dd")
    );
}