package com.shandov.autoria.contoller;

import com.shandov.autoria.domain.Gearbox;
import com.shandov.autoria.service.GearboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gearbox")
public class GearboxController {

    private final GearboxService gearboxService;

    @GetMapping("/all")
    public List<Gearbox> getAll(){
        return gearboxService.getAll();
    }
}
