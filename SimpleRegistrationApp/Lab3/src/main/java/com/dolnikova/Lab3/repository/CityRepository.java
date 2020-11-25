package com.dolnikova.Lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dolnikova.Lab3.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    City findByCity(String city);

}
