package com.yourtravelpartner.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtravelpartner.backend.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByNameContainingIgnoreCase(String keyword);
}
