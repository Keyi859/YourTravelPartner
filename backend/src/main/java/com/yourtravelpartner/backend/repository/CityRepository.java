package com.yourtravelpartner.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtravelpartner.backend.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByCountry_Id(Long countryId);

    List<City> findByNameContainingIgnoreCase(String name);
}