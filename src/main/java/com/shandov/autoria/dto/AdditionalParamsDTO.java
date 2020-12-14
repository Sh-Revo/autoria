package com.shandov.autoria.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalParamsDTO {

    private int lang_id;

    private int page;

    private int viewTypeId;

    private String target;

    private String section;

    private String catalogName;

    private String elastica;

    private String nodejs;
}
