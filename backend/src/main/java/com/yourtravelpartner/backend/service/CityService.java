package com.yourtravelpartner.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yourtravelpartner.backend.model.City;
import com.yourtravelpartner.backend.repository.CityRepository;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    public List<City> getCitiesByCountryId(Long countryId) {
        return cityRepository.findByCountry_Id(countryId);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }
}