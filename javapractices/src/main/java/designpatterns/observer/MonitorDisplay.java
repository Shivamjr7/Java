package designpatterns.observer;

public class MonitorDisplay implements IObserver{

    private WeatherStation weatherStation;

    MonitorDisplay(WeatherStation weatherStation)
    {
        this.weatherStation = weatherStation;
    }
    @Override
    public void update() {

        System.out.println("Updating weather in monitor display , temp now : "+ weatherStation.getTemperature());
    }
}
