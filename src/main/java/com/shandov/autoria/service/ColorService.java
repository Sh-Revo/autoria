package com.shandov.autoria.service;

import com.shandov.autoria.config.WebConfig;
import com.shandov.autoria.domain.Color;
import com.shandov.autoria.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepository colorRepository;

    private final WebConfig webConfig;

    @PostConstruct
    public void startWebClient(){
        List<Color> list = webConfig.createWebClient().get().uri("/colors?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d").retrieve().bodyToFlux(Color.class).collectList().block();
        colorRepository.saveAll(list);
    }

    public List<Color> getAll(){
        return colorRepository.findAll();
    }
}
