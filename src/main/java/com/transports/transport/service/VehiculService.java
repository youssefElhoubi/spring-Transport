package com.transports.transport.service;

import com.transports.transport.repository.VehiculRepository;

public class VehiculService {
    private VehiculRepository vehiculRepository;

    public VehiculService(VehiculRepository vehiculRepository) {
        this.vehiculRepository = vehiculRepository;
    }

}
