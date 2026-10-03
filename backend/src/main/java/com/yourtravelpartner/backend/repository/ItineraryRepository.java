package com.yourtravelpartner.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtravelpartner.backend.model.Itinerary;

public interface ItineraryRepository
        extends JpaRepository<Itinerary, Long> {

    List<Itinerary> findByTrip_IdOrderByDayNumberAsc(Long tripId);
}