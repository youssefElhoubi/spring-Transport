package com.transports.transport.service;

import com.transports.transport.entities.Tour;
import com.transports.transport.repository.tourRepository;

import java.util.List;

public class TourService {
    private tourRepository tourRepository;

    public TourService(tourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }
    // Get all tours
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    // Find a tour by ID
    public Tour findById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found with ID: " + id));
    }

    // Save a new tour
    public Tour save(Tour t) {
        return tourRepository.save(t);
    }

    // Update an existing tour
    public Tour update(Tour t) {
        Tour tour = tourRepository.findById(t.getId())
                .orElseThrow(() -> new RuntimeException("Tour not found with ID: " + t.getId()));

        tour.setDate(t.getDate());
        tour.setDeliveries(t.getDeliveries());
        tour.setVehicle(t.getVehicle());
        tour.setStatus(t.getStatus());
        tour.setWarehouse(t.getWarehouse());
        tour.setTotalDistance(t.getTotalDistance());
        tour.setId(t.getId());

        return tourRepository.save(tour);
    }

    // Optional: Delete a tour by ID
    public void deleteById(Long id) throws RuntimeException {
        if (!tourRepository.existsById(id)) {
            throw new RuntimeException("Tour not found with ID: " + id);
        }
        tourRepository.deleteById(id);
    }
}
