package com.shandov.autoria.contoller;

import com.shandov.autoria.domain.Gearbox;
import com.shandov.autoria.domain.Option;
import com.shandov.autoria.service.GearboxService;
import com.shandov.autoria.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/option")
public class OptionController {

    private final OptionService optionService;

    @GetMapping("/all")
    public List<Option> getAll(){
        return optionService.getAll();
    }
}
