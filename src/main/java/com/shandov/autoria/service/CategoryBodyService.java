package com.shandov.autoria.service;

import com.shandov.autoria.domain.Category;
import com.shandov.autoria.domain.CategoryBody;
import com.shandov.autoria.repository.CategoryBodyRepository;
import com.shandov.autoria.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryBodyService {

    private final CategoryBodyRepository categoryBodyRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    private WebClient webClient;

    @PostConstruct
    public void startWebClient(){
        List<Category> categories = categoryRepository.findAll();
        for(Category category: categories) {
            List<CategoryBody> list = webClient
                    .get()
                    .uri("/categories/"+category.getValue()+"/bodystyles?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d")
                    .retrieve()
                    .bodyToFlux(CategoryBody.class)
                    .collectList()
                    .block();

            for (CategoryBody categoryBody : list) {
                categoryBody.setCategory(category);
            }
            categoryBodyRepository.saveAll(list);
        }
    }

    public List<CategoryBody> getAll(){
        return categoryBodyRepository.findAll();
    }
}
