package designpatterns.observer;

import java.util.Random;

public class WeatherService {




    public static int getTemp()
    {
        Random random = new Random();
        int temperature = random.nextInt(50) + 0;
        return temperature;
    }

    public static boolean isTempChanged()
    {
        // your logic to check weather has changed
        return true;
    }

}
