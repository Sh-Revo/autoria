package com.shandov.autoria.service;

import com.shandov.autoria.config.WebConfig;
import com.shandov.autoria.domain.Country;
import com.shandov.autoria.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    private final WebConfig webConfig;

    @PostConstruct
    public void startWebClient(){
        List<Country> list = webConfig.createWebClient().get().uri("/countries?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d").retrieve().bodyToFlux(Country.class).collectList().block();
        countryRepository.saveAll(list);
    }

    public List<Country> getAll(){
        return countryRepository.findAll();
    }
}
