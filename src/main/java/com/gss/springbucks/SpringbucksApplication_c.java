package com.gss.springbucks;

import com.gss.springbucks.model.Coffee;
import com.gss.springbucks.model.CoffeeOrder;
import com.gss.springbucks.model.OrderState;
import com.gss.springbucks.repository.CoffeeOrderRepository;
import com.gss.springbucks.repository.CoffeeRepository;
import com.gss.springbucks.service.CoffeeOrderService;
import com.gss.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@SpringBootApplication
//@EnableTransactionManagement
//@EnableJpaRepositories
//@EnableAspectJAutoProxy
//@Slf4j
public class SpringbucksApplication_c implements ApplicationRunner {

//	@Autowired
//	private CoffeeRepository coffeeRepository;
//	@Autowired
//	private CoffeeOrderRepository coffeeOrderRepository;
//	@Autowired
//	private CoffeeService coffeeService;
//	@Autowired
//	private CoffeeOrderService coffeeOrderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication_c.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
//		initOrders();
//		findOrders();
//		testServices();
	}

	private void initOrders() {
//		Coffee espresso = Coffee.builder().name("espresso")
//				.price(Money.of(CurrencyUnit.of("CNY"), 20.0))
//				.build();
//		coffeeRepository.save(espresso);
//		log.info("Coffee: {}", espresso);
//
//		Coffee latte = Coffee.builder().name("latte")
//				.price(Money.of(CurrencyUnit.of("CNY"), 30.0))
//				.build();
//		coffeeRepository.save(latte);
//		log.info("Coffee: {}", latte);
//
//		CoffeeOrder order = CoffeeOrder.builder()
//				.customer("Li Lei")
//				.items(Collections.singletonList(espresso))
//				.state(OrderState.INIT)
//				.build();
//		coffeeOrderRepository.save(order);
//		log.info("Order: {}", order);
//
//		order = CoffeeOrder.builder()
//				.customer("Han mei mei")
//				.items(Arrays.asList(espresso, latte))
//				.state(OrderState.INIT)
//				.build();
//		coffeeOrderRepository.save(order);
//		log.info("Order: {}", order);
	}

	private void findOrders() {
//		coffeeRepository.findAll(Sort.by(Sort.Direction.DESC,"id"))
//				.forEach(c -> log.info("Loading {}", c));
//
//		List<CoffeeOrder> list = coffeeOrderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
//		log.info("findTop3ByOrderByUpdateTimeDescIdAsc: {}", getJoinedOrderId(list));
//
//		list = coffeeOrderRepository.findByCustomerOrderById("Li Lei");
//		log.info("findByCustomerOrderById: {}", getJoinedOrderId(list));
//
//		list.forEach(o -> {
//			log.info("Order {}", o.getId());
//			o.getItems().forEach(i -> log.info(" Item {}", i));
//		});
//
//		list = coffeeOrderRepository.findByItems_Name("latte");
//		log.info("findByItems_Name: {}", getJoinedOrderId(list));
	}

	private String getJoinedOrderId(List<CoffeeOrder> list) {
		return list.stream().map(o -> o.getId().toString())
				.collect(Collectors.joining(","));
	}

	private void testServices() {
//		log.info("All Coffee: {}", coffeeRepository.findAll());
//		Optional<Coffee> latte = coffeeService.findOneCoffee("LATTE");
//		if(latte.isPresent()) {
//			CoffeeOrder order = coffeeOrderService.createOrder("XiaoGuo", latte.get());
//			log.info("Update INIT to PAID {}", coffeeOrderService.updateState(order, OrderState.PAID));
//		}
//		List<CoffeeOrder> coffeeOrders = coffeeOrderService.findCoffeeOrderByCustomer("Li");
//		log.info("Latte Orders: {}", coffeeOrders);
	}

}
