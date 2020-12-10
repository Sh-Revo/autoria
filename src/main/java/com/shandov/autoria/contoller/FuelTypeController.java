package com.shandov.autoria.contoller;

import com.shandov.autoria.domain.FuelType;
import com.shandov.autoria.service.FuelTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fueltype")
public class FuelTypeController {

    private final FuelTypeService fuelTypeService;

    @GetMapping("/all")
    public List<FuelType> getAll(){
        return fuelTypeService.getAll();
    }
}
