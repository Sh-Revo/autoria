package com.shandov.autoria.contoller;

import com.shandov.autoria.domain.Country;
import com.shandov.autoria.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/all")
    public List<Country> getAll(){
        return countryService.getAll();
    }
}
