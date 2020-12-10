package com.shandov.autoria.service;

import com.shandov.autoria.config.WebConfig;
import com.shandov.autoria.contoller.FuelTypeController;
import com.shandov.autoria.domain.FuelType;
import com.shandov.autoria.repository.FuelTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;

    private final WebConfig webConfig;

    @PostConstruct
    public void startWebClient(){
        List<FuelType> list = webConfig.createWebClient().get().uri("/type?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d").retrieve().bodyToFlux(FuelType.class).collectList().block();
        fuelTypeRepository.saveAll(list);
    }

    public List<FuelType> getAll(){
        return fuelTypeRepository.findAll();
    }
}
