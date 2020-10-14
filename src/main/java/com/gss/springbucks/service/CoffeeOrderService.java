package com.gss.springbucks.service;

import com.gss.springbucks.model.Coffee;
import com.gss.springbucks.model.CoffeeOrder;
import com.gss.springbucks.model.OrderState;
import com.gss.springbucks.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@Transactional
public class CoffeeOrderService {

    @Autowired
    private CoffeeOrderRepository orderRepository;

    public CoffeeOrder createOrder(String customer, Coffee...coffees) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffees)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info("New Order: {}", saved);
        return saved;
    };

    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State Order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Update Order: {}", order);
        return true;
    }

    public List<CoffeeOrder> findCoffeeOrderByCustomer(String name) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("customer", ExampleMatcher.GenericPropertyMatchers.startsWith());
        CoffeeOrder coffeeOrder = CoffeeOrder.builder().customer(name).build();
        Example<CoffeeOrder> example = Example.of(coffeeOrder, exampleMatcher);
        List<CoffeeOrder> coffeeOrders = orderRepository.findAll(example);
        log.info("findCoffeeOrderByCustomer: {}", coffeeOrders);
        return coffeeOrders;
    }

}
