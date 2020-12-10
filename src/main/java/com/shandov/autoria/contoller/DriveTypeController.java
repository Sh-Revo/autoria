package com.shandov.autoria.contoller;

import com.shandov.autoria.domain.DriveType;
import com.shandov.autoria.service.DriveTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/drive-type")
public class DriveTypeController {

    private final DriveTypeService driveTypeService;

    @GetMapping("/all")
    public List<DriveType> getAll(){
        return driveTypeService.getAll();
    }
}
