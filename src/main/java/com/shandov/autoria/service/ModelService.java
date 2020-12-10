package com.shandov.autoria.service;

import com.shandov.autoria.domain.Category;
import com.shandov.autoria.domain.Model;
import com.shandov.autoria.repository.CategoryRepository;
import com.shandov.autoria.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;
    private final CategoryRepository categoryRepository;

//    @Autowired
//    private WebClient webClient;
//
//    @PostConstruct
//    public void startWebClient(){
//        List<Category> categories = categoryRepository.findAll();
//        for(Category category: categories) {
//            List<Model> list = webClient
//                    .get()
//                    .uri("/categories/"+category.getValue()+"/marks?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d")
//                    .retrieve()
//                    .bodyToFlux(Model.class)
//                    .collectList()
//                    .block();
//
//            for (Model model : list) {
//                model.setCategory(category);
//            }
//            modelRepository.saveAll(list);
//        }
//    }
//
//    public List<Model> getAll(){
//        return modelRepository.findAll();
//    }
}
