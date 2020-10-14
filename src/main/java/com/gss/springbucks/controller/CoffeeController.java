package com.gss.springbucks.controller;

import com.gss.springbucks.controller.request.NewCoffeeRequest;
import com.gss.springbucks.model.Coffee;
import com.gss.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("")
    @ResponseBody
    public List<Coffee> getAll() {
        return coffeeService.getAllCoffee();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee create(@RequestBody NewCoffeeRequest coffeeRequest) {
        log.info("Received New Coffee: {}", coffeeRequest);
        Double price = Double.parseDouble(coffeeRequest.getPrice());
        log.info("Price: {}", price);
        return coffeeService.createCoffee(coffeeRequest.getName(), price);
    };
}
