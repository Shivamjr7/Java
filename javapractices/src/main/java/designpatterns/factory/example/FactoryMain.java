package designpatterns.factory.example;

public class FactoryMain {


    public static void main(String[] args) {

        //transport by road
        LogisticsFactory road = new RoadLogistics();
        Transport roadTransport = road.createTransport("Truck");
        roadTransport.deliver();

        LogisticsFactory sea = new SeaLogistics();
        Transport seaTransport = road.createTransport("Ship");
        seaTransport.deliver();


    }
}
