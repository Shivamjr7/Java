package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements IObservable {

    List<IObserver> observers = new ArrayList<>();


    @Override
    public void addObserver(IObserver observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {

        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {

        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public int getTemperature() {
        // get this from a weather service
        // check if temp changed : if yes : get Weatherservice.getTemp and display

        while (true) {
            //sleep for 5 seconds and then check temp

            System.out.println("Sleeping for 1 second....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            if (WeatherService.isTempChanged()) {
                System.out.println("Weather update...");
                int temp = WeatherService.getTemp();
                return temp;
            }
        }
        return -273;
    }
}
