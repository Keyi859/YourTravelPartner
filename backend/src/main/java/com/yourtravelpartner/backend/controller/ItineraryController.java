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

import com.yourtravelpartner.backend.model.Itinerary;
import com.yourtravelpartner.backend.service.ItineraryService;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping
    public List<Itinerary> getAllItineraries() {
        return itineraryService.getAllItineraries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itinerary> getItineraryById(
            @PathVariable Long id) {

        return itineraryService.getItineraryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/trip/{tripId}")
    public List<Itinerary> getItinerariesByTripId(
            @PathVariable Long tripId) {

        return itineraryService.getItinerariesByTripId(tripId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Itinerary createItinerary(
            @RequestBody Itinerary itinerary) {

        return itineraryService.createItinerary(itinerary);
    }
}
