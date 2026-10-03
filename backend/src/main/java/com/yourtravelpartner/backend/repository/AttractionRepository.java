package com.yourtravelpartner.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourtravelpartner.backend.model.Attraction;

public interface AttractionRepository
        extends JpaRepository<Attraction, Long> {

    List<Attraction> findByCity_Id(Long cityId);

    List<Attraction> findByCategoryIgnoreCase(String category);
}