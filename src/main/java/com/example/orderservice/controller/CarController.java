package com.example.orderservice.controller;

import com.example.orderservice.pojo.Car;
import com.example.orderservice.service.CarService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getAllCars")
    public ResponseEntity<?> getAllCars(){
        List<Car> cars = carService.getAllCars();
        return  ResponseEntity.ok(cars);
    }

//    @PatchMapping("/updateQuantity")
//    public boolean updateCar() throws IOException {
//        Car car = carService.getCarById((String) rabbitTemplate.convertSendAndReceive("OrderDirectExchange","update",""));
//        if (car != null){
//
//            carService.updateCar(new Car(car.get_id(),);
//            return true;
//        } else {
//            return false;
//        }

//    }

}
