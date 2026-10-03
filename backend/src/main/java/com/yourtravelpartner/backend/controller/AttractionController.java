package com.yourtravelpartner.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yourtravelpartner.backend.model.Attraction;
import com.yourtravelpartner.backend.service.AttractionService;

@RestController
@RequestMapping("/api/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public List<Attraction> getAllAttractions() {
        return attractionService.getAllAttractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attraction> getAttractionById(
            @PathVariable Long id) {

        return attractionService.getAttractionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/city/{cityId}")
    public List<Attraction> getAttractionsByCityId(
            @PathVariable Long cityId) {

        return attractionService.getAttractionsByCityId(cityId);
    }

    @GetMapping("/category/{category}")
    public List<Attraction> getAttractionsByCategory(
            @PathVariable String category) {

        return attractionService.getAttractionsByCategory(category);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attraction createAttraction(
            @RequestBody Attraction attraction) {

        return attractionService.createAttraction(attraction);
    }
}