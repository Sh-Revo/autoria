package com.shandov.autoria.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shandov.autoria.domain.*;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchDTO {

    @NotNull
    private Brand brand;

    @NotNull
    private Category category;

    @NotNull
    private CategoryBody categoryBody;

    @NotNull
    private Region region;

    @NotNull
    private City city;

    @NotNull
    private Color color;

    @NotNull
    private Country country;

    @NotNull
    private DriveType driveType;

    @NotNull
    private FuelType fuelType;

    @NotNull
    private Gearbox gearbox;

    @NotNull
    private Option option;


}
