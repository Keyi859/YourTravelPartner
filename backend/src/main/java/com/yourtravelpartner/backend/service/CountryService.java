package com.yourtravelpartner.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yourtravelpartner.backend.model.Country;
import com.yourtravelpartner.backend.repository.CountryRepository;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public Optional<Country> getCountryByIsoCode(String isoCode) {
        return countryRepository.findByIsoCode(isoCode);
    }

    public List<Country> searchCountries(String name) {
    return countryRepository.findByNameContainingIgnoreCase(name);
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }
}
