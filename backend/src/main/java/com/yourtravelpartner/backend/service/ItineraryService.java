package com.yourtravelpartner.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yourtravelpartner.backend.model.Itinerary;
import com.yourtravelpartner.backend.repository.ItineraryRepository;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public List<Itinerary> getAllItineraries() {
        return itineraryRepository.findAll();
    }

    public Optional<Itinerary> getItineraryById(Long id) {
        return itineraryRepository.findById(id);
    }

    public List<Itinerary> getItinerariesByTripId(Long tripId) {
        return itineraryRepository.findByTrip_IdOrderByDayNumberAsc(tripId);
    }

    public Itinerary createItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }
}