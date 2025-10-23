package com.transports.transport.controllers;

import com.transports.transport.MapperImplementation.VehiculMapperImpl;
import com.transports.transport.service.VehiculService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("vehicul")
public class VehiculController {
    private final VehiculMapperImpl vehiculMapper;
    private final VehiculService vehiculService;
    public VehiculController(VehiculService vehiculService, VehiculMapperImpl vehiculMapper) {
        this.vehiculService =vehiculService;
        this.vehiculMapper =  vehiculMapper;
    }
    
}
