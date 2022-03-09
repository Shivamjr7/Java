package designpatterns.observer;

public class ObserverMain {

    public static void main(String[] args) {


        WeatherStation weatherStation = new WeatherStation();

        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherStation);
        MonitorDisplay monitorDisplay = new MonitorDisplay(weatherStation);

        //adding observers to observable
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(monitorDisplay);

        // notifying all observers on weather change
        weatherStation.notifyObserver();

    }
}
