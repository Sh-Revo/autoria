package com.shandov.autoria.service;

import com.shandov.autoria.domain.City;
import com.shandov.autoria.domain.Region;
import com.shandov.autoria.repository.CityRepository;
import com.shandov.autoria.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final RegionRepository regionRepository;

    @Autowired
    private WebClient webClient;

    @PostConstruct
    public void startWebClient(){
        List<Region> regions = regionRepository.findAll();
        for(Region region: regions) {
            List<City> list = webClient
                    .get()
                    .uri("/states/"+region.getValue()+"/cities?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d")
                    .retrieve()
                    .bodyToFlux(City.class)
                    .collectList()
                    .block();

            for (City city : list) {
                city.setRegion(region);
            }
            cityRepository.saveAll(list);
        }
    }

    public List<City> getAll(){
        return cityRepository.findAll();
    }
}
