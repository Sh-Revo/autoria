package com.shandov.autoria.contoller;

import com.shandov.autoria.domain.Color;
import com.shandov.autoria.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/color")
public class ColorController {

    private final ColorService colorService;

    @GetMapping("/all")
    public List<Color> getAll(){
        return colorService.getAll();
    }
}
