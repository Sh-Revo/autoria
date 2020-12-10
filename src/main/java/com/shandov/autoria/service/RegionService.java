package com.shandov.autoria.service;

import com.shandov.autoria.config.WebConfig;
import com.shandov.autoria.domain.Region;
import com.shandov.autoria.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    private final WebConfig webConfig;

    @PostConstruct
    public void startWebClient(){
        List<Region> list = webConfig.createWebClient().get().uri("/states?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d").retrieve().bodyToFlux(Region.class).collectList().block();
        regionRepository.saveAll(list);
    }

    public List<Region> getAll(){
        return regionRepository.findAll();
    }
}
