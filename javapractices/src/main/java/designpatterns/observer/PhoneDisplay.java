package designpatterns.observer;

public class PhoneDisplay implements IObserver {

    private WeatherStation weatherStation;

    PhoneDisplay(WeatherStation weatherStation)
    {
        this.weatherStation = weatherStation;
    }
    @Override
    public void update() {

        System.out.println("Updating weather in phone display , temp now : "+ weatherStation.getTemperature());
    }
}
