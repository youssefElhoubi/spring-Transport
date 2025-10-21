package com.transports.transport.service;

import com.transports.transport.repository.WarehouseRepository;

public class WarehouseService {
    private WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }
}
