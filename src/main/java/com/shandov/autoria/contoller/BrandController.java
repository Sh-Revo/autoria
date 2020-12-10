package com.shandov.autoria.contoller;

import com.shandov.autoria.domain.Brand;
import com.shandov.autoria.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/all")
    public List<Brand> getAll(){
        return brandService.getAll();
    }


}
