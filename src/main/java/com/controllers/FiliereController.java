package com.controllers;

import com.service.FiliereService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filiere/")
@RequiredArgsConstructor
public class FiliereController {

    private final FiliereService filiereService;

    @GetMapping("msg")
    public String getMessage(){
        return "Hello From Jsf Api";
    }
}
