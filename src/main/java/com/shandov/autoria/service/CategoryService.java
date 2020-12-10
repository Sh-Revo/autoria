package com.shandov.autoria.service;

import com.shandov.autoria.config.WebConfig;
import com.shandov.autoria.domain.Category;
import com.shandov.autoria.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    private WebClient webClient;

    @PostConstruct
    public void startWebClient(){
        List<Category> list = webClient
                .get()
                .uri("/categories/?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d")
                .retrieve()
                .bodyToFlux(Category.class)
                .collectList()
                .block();
        categoryRepository.saveAll(list);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
}
