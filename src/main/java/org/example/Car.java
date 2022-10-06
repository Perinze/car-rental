package org.example;

public class Car {
    String license;
    String brand;
    String model;
    CarType type;
    Double price;

    public Car(String license, String brand, String model, CarType type, Double price) {
        this.license = license;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.price = price;
    }

    public Car(String license, String brand, String model, String type, Double price) {
        this.license = license;
        this.brand = brand;
        this.model = model;
        this.type = CarType.valueOf(type);
        this.price = price;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                license +
                ", " + brand +
                ", " + model +
                ", " + type +
                ", " + price +
                '}';
    }
}
