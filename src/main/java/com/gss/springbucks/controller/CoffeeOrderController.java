package com.gss.springbucks.controller;

import com.gss.springbucks.controller.request.NewOrderRequest;
import com.gss.springbucks.model.Coffee;
import com.gss.springbucks.model.CoffeeOrder;
import com.gss.springbucks.service.CoffeeOrderService;
import com.gss.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/coffeeOrder")
public class CoffeeOrderController {
    @Autowired
    private CoffeeOrderService coffeeOrderService;
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("Receive new Order {}", newOrder);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[] {});
        return coffeeOrderService.createOrder(newOrder.getCustomer(), coffeeList);
    };
}
