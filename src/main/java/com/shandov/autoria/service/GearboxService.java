package com.shandov.autoria.service;

import com.shandov.autoria.domain.Category;
import com.shandov.autoria.domain.Gearbox;
import com.shandov.autoria.repository.CategoryRepository;
import com.shandov.autoria.repository.GearboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GearboxService {

    private final GearboxRepository gearboxRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    private WebClient webClient;

    @PostConstruct
    public void startWebClient(){
        List<Category> categories = categoryRepository.findAll();
        for(Category category: categories) {
            List<Gearbox> list = webClient
                    .get()
                    .uri("/categories/"+category.getValue()+"/gearboxes?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d")
                    .retrieve()
                    .bodyToFlux(Gearbox.class)
                    .collectList()
                    .block();

            for (Gearbox gearbox : list) {
                gearbox.setCategory(category);
            }
            gearboxRepository.saveAll(list);
        }
    }

    public List<Gearbox> getAll(){
        return gearboxRepository.findAll();
    }
}
