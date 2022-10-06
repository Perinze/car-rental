package org.example;

import java.util.function.Predicate;

public interface CarInterface {
    public abstract void addCar(Car car);
    public abstract void addCar(String license, String brand, String model, CarType type, Double price);
    public abstract void addCar(String license, String brand, String model, String type, Double price);
    public abstract void show(Predicate<Car> filter);
    public abstract void remove(String license);
    public abstract void remove(Predicate<Car> filter);
    public abstract double calc(Predicate<Car> filter, long days);
}
