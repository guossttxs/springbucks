package com.gss.springbucks.repository;

import com.gss.springbucks.model.Coffee;

import java.util.List;

public interface CoffeeRepository extends BaseRepository<Coffee, Long> {
    List<Coffee> findByNameInOrderById(List<String> names);
}
