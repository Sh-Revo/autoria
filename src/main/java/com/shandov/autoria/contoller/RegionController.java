package com.shandov.autoria.contoller;


import com.shandov.autoria.domain.Region;
import com.shandov.autoria.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/region")
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/all")
    public List<Region> getAll(){
        return regionService.getAll();
    }
}
