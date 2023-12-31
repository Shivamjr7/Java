package designpatterns.factory;

abstract class Vehicle {

	abstract int getWheel();

	@Override
	public String toString() {
		return " Wheel :" + this.getWheel();
	}

}

class Car extends Vehicle {

	Car(int wheel) {
		this.wheel = wheel;
	}

	int wheel;

	@Override
	int getWheel() {
		return wheel;
	}
}

class Bike extends Vehicle {

	int wheel;

	Bike(int wheel) {
		this.wheel = wheel;
	}

	@Override
	int getWheel() {

		return wheel;
	}

}

class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if (type == "car") {
			return new Car(wheel);
		} else if (type == "bike") {
			return new Bike(wheel);
		}

		return null;
	}
}



public class FactoryPattern {

	public static void main(String[] args) {

		Vehicle car = VehicleFactory.getInstance("car", 5);
		System.out.println(car.getWheel());
		Vehicle bike = VehicleFactory.getInstance("bike", 4);
		System.out.println(bike.getWheel());
	}

}
