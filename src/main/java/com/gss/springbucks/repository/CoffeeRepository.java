package com.gss.springbucks.repository;

import com.gss.springbucks.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
