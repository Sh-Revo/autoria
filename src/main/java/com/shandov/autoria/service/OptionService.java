package com.shandov.autoria.service;

import com.shandov.autoria.domain.Category;
import com.shandov.autoria.domain.Option;
import com.shandov.autoria.repository.CategoryRepository;
import com.shandov.autoria.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final OptionRepository optionRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    private WebClient webClient;

    @PostConstruct
    public void startWebClient(){
        List<Category> categories = categoryRepository.findAll();
        for(Category category: categories) {
            List<Option> list = webClient
                    .get()
                    .uri("/categories/"+category.getValue()+"/options?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d")
                    .retrieve()
                    .bodyToFlux(Option.class)
                    .collectList()
                    .block();

            for (Option option : list) {
                option.setCategory(category);
            }
            optionRepository.saveAll(list);
        }
    }

    public List<Option> getAll(){
        return optionRepository.findAll();
    }
}
