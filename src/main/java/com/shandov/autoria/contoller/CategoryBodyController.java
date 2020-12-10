package com.shandov.autoria.contoller;

import com.shandov.autoria.domain.CategoryBody;
import com.shandov.autoria.service.CategoryBodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category-body")
public class CategoryBodyController {

    private final CategoryBodyService categoryBodyService;

    @GetMapping("/all")
    public List<CategoryBody> getAll(){
        return categoryBodyService.getAll();
    }
}
