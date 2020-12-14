package com.shandov.autoria.service;

import com.shandov.autoria.config.WebConfig;
import com.shandov.autoria.domain.Brand;
import com.shandov.autoria.domain.Category;
import com.shandov.autoria.repository.BrandRepository;
import com.shandov.autoria.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    private WebClient webClient;

    @PostConstruct
    public void startWebClient(){
        List<Category> categories = categoryRepository.findAll();
        for(Category category: categories) {
            List<Brand> list = webClient
                    .get()
                    .uri("categories/"+category.getValue()+"/marks?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d")
                    .retrieve()
                    .bodyToFlux(Brand.class)
                    .collectList()
                    .block();

            for (Brand brand : list) {
                brand.setCategory(category);
            }
            brandRepository.saveAll(list);
        }
    }

    public List<Brand> getAll(){
        return brandRepository.findAll();
    }

}
