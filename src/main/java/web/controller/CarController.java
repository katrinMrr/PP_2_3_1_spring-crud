package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {
    @Autowired
private CarService carService;
    @GetMapping(value = "/cars")

    public String printCar(ModelMap model, HttpServletRequest request) {
        int size = Integer.parseInt(request.getParameter("count")== null ? "5"
                :request.getParameter("count"));
        List<Car> cars;
        cars=carService.getListCar().stream().limit(size).collect(Collectors.toList());
        model.addAttribute("cars", cars);
        return "cars";
    }
}


