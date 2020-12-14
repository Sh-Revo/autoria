package com.shandov.autoria.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchRequestDTO {

    @NotNull
    private AdditionalParamsDTO additional_params;

    @NotNull
    private ResultDTO result;
}
