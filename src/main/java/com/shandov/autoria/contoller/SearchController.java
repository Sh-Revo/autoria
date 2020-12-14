package com.shandov.autoria.contoller;

import com.shandov.autoria.dto.SearchDTO;
import com.shandov.autoria.dto.SearchRequestDTO;
import com.shandov.autoria.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/search", consumes = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/post")
    public List<SearchRequestDTO> postController(@RequestBody SearchDTO searchDTO){

        return searchService.postRequest(searchDTO);
    }

//    @GetMapping("/getSearch")
//    public List<SearchDTO> getSearch(){
//        return searchService.getSearch();
//    }
}
