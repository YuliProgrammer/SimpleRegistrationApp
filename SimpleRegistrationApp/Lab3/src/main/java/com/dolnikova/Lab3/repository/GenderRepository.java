package com.dolnikova.Lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dolnikova.Lab3.model.Gender;
import com.dolnikova.Lab3.model.UserGender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

    Gender findByUserGender(UserGender UserGender);

}
