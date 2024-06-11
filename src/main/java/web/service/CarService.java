package web.service;

import web.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getSomeCars(int count, List<Car> cars);
}
