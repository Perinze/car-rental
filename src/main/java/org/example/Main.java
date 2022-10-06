package org.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        Scanner sc = new Scanner(System.in);
        for (;;) {
            var params = parseCommand(sc.nextLine().toLowerCase());
            var cmd = params.remove(0);
            switch (cmd) {
                case "add" -> carService.addCar(
                        params.get(0),
                        params.get(1),
                        params.get(2),
                        params.get(3),
                        Double.parseDouble(params.get(4))
                );
                case "show" -> {
                    carService.show(getFilter(params));
                }
                case "rent" -> {
                    long days = Long.parseLong(params.remove(0));
                    System.out.println(carService.calc(getFilter(params), days));
                }
                case "help" -> System.out.print(help);
            }
        }
    }

    static List<String> parseCommand(String command) {
        return new ArrayList<>(List.of(command.split(" +")));
    }

    static Predicate<Car> getFilter(List<String> params) {
        var it = params.listIterator();
        Predicate<Car> filter = car -> true;
        Class<Car> cls = Car.class;
        while (it.hasNext()) {
            String f = it.next();
            String v = it.next();
            Object value = "price".equals(f) ? Double.parseDouble(v) : v;
            Field field;
            try {
                field = cls.getDeclaredField(f);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            field.setAccessible(true);
            filter = filter.and(car -> {
                try {
                    return field.get(car).equals(value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return filter;
    }

    static String help = "add LICENSE BRAND MODEL TYPE PRICE\n"
                       + "show [FIELD VALUE]...\n"
                       + "rent DAYS [FIELD VALUE]...\n";
}