package designpatterns.factory.example;

public class SeaLogistics implements  LogisticsFactory{

    @Override
    public Transport createTransport(String type) {

        if(type=="ship")
            return new Ship();

        return null;
    }
}
