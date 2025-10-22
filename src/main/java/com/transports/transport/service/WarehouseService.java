package com.transports.transport.service;

import com.transports.transport.entities.Warehouse;
import com.transports.transport.repository.WarehouseRepository;

import java.util.List;

public class WarehouseService {
    private WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    // Get all warehouses
    public List<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    // Find a warehouse by ID
    public Warehouse findById(Long id) {
        return warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found with ID: " + id));
    }

    // Save a new warehouse
    public Warehouse save(Warehouse w) {
        return warehouseRepository.save(w);
    }

    // Update an existing warehouse
    public Warehouse update(Warehouse w) {
        Warehouse warehouse = warehouseRepository.findById(w.getId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found with ID: " + w.getId()));

        warehouse.setAddress(w.getAddress());
        warehouse.setLongitude(w.getLongitude());
        warehouse.setLatitude(w.getLatitude());
        warehouse.setId(w.getId());
        warehouse.setOpeningHours(w.getOpeningHours());

        return warehouseRepository.save(warehouse);
    }
    
    // Optional: Delete a warehouse by ID
    public void deleteById(Long id) {
        if (!warehouseRepository.existsById(id)) {
            throw new RuntimeException("Warehouse not found with ID: " + id);
        }
        warehouseRepository.deleteById(id);
    }
}
