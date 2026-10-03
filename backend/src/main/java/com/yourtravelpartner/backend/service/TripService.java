package com.yourtravelpartner.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yourtravelpartner.backend.model.Trip;
import com.yourtravelpartner.backend.repository.TripRepository;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public List<Trip> searchTrips(String keyword) {
        return tripRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }
}