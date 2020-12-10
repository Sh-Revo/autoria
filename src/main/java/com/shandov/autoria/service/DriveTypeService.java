package com.shandov.autoria.service;

import com.shandov.autoria.domain.Category;
import com.shandov.autoria.domain.DriveType;
import com.shandov.autoria.repository.CategoryRepository;
import com.shandov.autoria.repository.DriveTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriveTypeService {

    private final DriveTypeRepository driveTypeRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    private WebClient webClient;

    @PostConstruct
    public void startWebClient(){
        List<Category> categories = categoryRepository.findAll();
        for(Category category: categories) {
            List<DriveType> list = webClient
                    .get()
                    .uri("/categories/"+category.getValue()+"/driverTypes?api_key=etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d")
                    .retrieve()
                    .bodyToFlux(DriveType.class)
                    .collectList()
                    .block();

            for (DriveType driveType : list) {
                driveType.setCategory(category);
            }
            driveTypeRepository.saveAll(list);
        }
    }

    public List<DriveType> getAll(){
        return driveTypeRepository.findAll();
    }
}
