package com.innova.masraftakip.config.data.repository;

import com.innova.masraftakip.config.data.entity.AggregateMasraf;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AggregateMasrafRepository extends CrudRepository<AggregateMasraf, Long> {
    List<AggregateMasraf> findByKisiIdAndPeriod(Long kisiId, String period);
}
