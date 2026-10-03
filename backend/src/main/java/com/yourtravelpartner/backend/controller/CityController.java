package com.yourtravelpartner.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yourtravelpartner.backend.model.City;
import com.yourtravelpartner.backend.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }
    @GetMapping("/search")
    public List<City> searchCities(@RequestParam String name) {
        return cityService.searchCities(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        return cityService.getCityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/country/{countryId}")
    public List<City> getCitiesByCountryId(@PathVariable Long countryId) {
        return cityService.getCitiesByCountryId(countryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }
}