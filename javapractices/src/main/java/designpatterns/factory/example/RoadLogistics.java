package designpatterns.factory.example;

public class RoadLogistics implements  LogisticsFactory{


    @Override
    public Transport createTransport(String type) {

        if(type =="Truck")
            return new Truck();
//        if(type =="Car")
//            return new Car();
//
        return null;
    }
}
