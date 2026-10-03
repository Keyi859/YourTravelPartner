package com.yourtravelpartner.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yourtravelpartner.backend.model.Attraction;
import com.yourtravelpartner.backend.repository.AttractionRepository;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;

    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    public Optional<Attraction> getAttractionById(Long id) {
        return attractionRepository.findById(id);
    }

    public List<Attraction> getAttractionsByCityId(Long cityId) {
        return attractionRepository.findByCity_Id(cityId);
    }

    public List<Attraction> getAttractionsByCategory(String category) {
        return attractionRepository.findByCategoryIgnoreCase(category);
    }

    public List<Attraction> searchAttractions(String name) {
        return attractionRepository.findByNameContainingIgnoreCase(name);  
    }

    public Attraction createAttraction(Attraction attraction) {
        return attractionRepository.save(attraction);
    }
}