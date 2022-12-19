package com.example.orderservice.controller;

import com.example.orderservice.pojo.Car;
import com.example.orderservice.pojo.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getAllOrder")
    public ResponseEntity<?> getAllOrder(){
        List<Order> order = orderService.getAllOrders();
        return  ResponseEntity.ok(order);
    }
    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestParam("carId") String carId
            ,
                                    @RequestParam("timeStart") String timeStart,
                                    @RequestParam("timeEnd") String timeEnd,
                                    @RequestParam("dateStart") String dateStart,
                                    @RequestParam("dateEnd") String dateEnd,
                                    @RequestParam("location") String location,
                                    @RequestParam("totalPrice") Integer totalPrice,
                                    @RequestParam("user_name") String user_name,
                                    @RequestParam("user_mail") String user_mail
                                    ){
        boolean status = orderService.addOrder(new Order(null,carId,timeStart,timeEnd,
                dateStart,dateEnd,location,totalPrice,"Pending",user_name, user_mail));
        rabbitTemplate.convertSendAndReceive("OrderDirectExchange","addOrder",carId);
        return ResponseEntity.ok(status);
    }
}