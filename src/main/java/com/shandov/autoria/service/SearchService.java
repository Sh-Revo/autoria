package com.shandov.autoria.service;

import com.shandov.autoria.config.WebConfig;
import com.shandov.autoria.dto.SearchDTO;
import com.shandov.autoria.dto.SearchRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final WebConfig webConfig;


    public List<SearchRequestDTO> postRequest(SearchDTO searchDTO ){
        MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();
        queryParam.add("api_key", "etxQ1jDBtEC6yeUsZ4WKNaFReHNf6cvsrLSHX28d");
        if (searchDTO.getCategory() != null){
            queryParam.add("category_id", String.valueOf(searchDTO.getCategory().getValue()));
        }
        if (searchDTO.getCategoryBody() != null){
            queryParam.add("bodystyle", String.valueOf(searchDTO.getCategoryBody().getValue()));
        }
        if (searchDTO.getBrand() != null){
            queryParam.add("marka_id", String.valueOf(searchDTO.getBrand().getValue()));
        }
        if (searchDTO.getBrand() != null){
            queryParam.add("marka_id", String.valueOf(searchDTO.getBrand().getValue()));
        }
        if (searchDTO.getRegion() != null){
            queryParam.add("state", String.valueOf(searchDTO.getRegion().getValue()));
        }
        if (searchDTO.getDriveType() != null){
            queryParam.add("driverTypes", String.valueOf(searchDTO.getRegion().getValue()));
        }
        if (searchDTO.getFuelType() != null){
            queryParam.add("type", String.valueOf(searchDTO.getFuelType().getValue()));
        }
        if (searchDTO.getGearbox() != null){
            queryParam.add("gearbox", String.valueOf(searchDTO.getGearbox().getValue()));
        }
        if (searchDTO.getColor() != null){
            queryParam.add("color", String.valueOf(searchDTO.getColor().getValue()));
        }
        if (searchDTO.getOption() != null){
            queryParam.add("option", String.valueOf(searchDTO.getOption().getValue()));
        }

        return webConfig.createWebClient().get()
                .uri(uriBuilder -> uriBuilder
                        .path("search")
                        .queryParams(queryParam)
                        .build())
                .retrieve().bodyToFlux(SearchRequestDTO.class).collectList().block();
    }
}
