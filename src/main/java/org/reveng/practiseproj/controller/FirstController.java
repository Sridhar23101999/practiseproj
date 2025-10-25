package org.reveng.practiseproj.controller;

import org.reveng.practiseproj.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstProject")
public class FirstController {

    private final FirstService firstService;

    @Autowired
    public FirstController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/testDB")
    public HttpStatus test (){
        firstService.testDB();
        return HttpStatus.OK;
    }
}
