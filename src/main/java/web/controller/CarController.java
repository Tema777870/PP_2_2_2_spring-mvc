package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller

public class CarController {
    private final CarServiceImp carService;

    @Autowired
    public CarController(CarServiceImp carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", required = false) String count,
                       Model model) {
        List<Car> cars = carService.getCars();
        if (count != null) {
            int countInt = Integer.parseInt(count);
            if (countInt <= 0) {
//                model.addAttribute("cars", carService.getSomeCars(countInt, cars));
                return "cars";
            } else if (countInt <= 5) {
                model.addAttribute("cars", carService.getSomeCars(countInt, cars));
                return "cars";
            } else {
                model.addAttribute("cars", carService.getSomeCars(5, cars));
                return "cars";
            }
        }
        return "cars";
    }
}
