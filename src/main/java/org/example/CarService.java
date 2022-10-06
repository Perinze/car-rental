package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarService implements CarInterface {

    public CarService() {
        cars = new ArrayList<>();
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void addCar(String license, String brand, String model, CarType type, Double price) {
        cars.add(new Car(license, brand, model, type, price));
    }

    @Override
    public void addCar(String license, String brand, String model, String type, Double price) {
        cars.add(new Car(license, brand, model, CarType.valueOf(type.toUpperCase()), price));
    }

    @Override
    public void show(Predicate<Car> filter) {
        cars.stream().filter(filter).forEach(System.out::println);
    }

    @Override
    public void remove(String license) {
        cars.removeIf(car -> license.equalsIgnoreCase(car.getLicense()));
    }

    @Override
    public void remove(Predicate<Car> filter) {
        cars.removeIf(filter);
    }

    @Override
    public double calc(Predicate<Car> filter, long days) {
        return days * cars.stream().filter(filter).mapToDouble(Car::getPrice).sum();
    }

    private final List<Car> cars;
}
