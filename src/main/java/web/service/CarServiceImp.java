package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImp implements CarService {


    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", "white", 2019));
        cars.add(new Car("Mercedes", "black", 2022));
        cars.add(new Car("Audi", "blue", 2016));
        cars.add(new Car("Toyota", "grey", 2014));
        cars.add(new Car("Nissan", "red", 2018));
    }

    @Override
    public List<Car> getSomeCars(int count, List<Car> cars) {
        if (count <= 5 && count >= 0) {
            return cars.stream().limit(count).collect(Collectors.toList());
        } else return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
