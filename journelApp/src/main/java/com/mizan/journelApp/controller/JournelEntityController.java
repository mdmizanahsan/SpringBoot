package com.mizan.journelApp.controller;


import com.mizan.journelApp.service.JournelEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journel")
public class JournelEntityController {

    @Autowired
    private JournelEntryService journelEntryService;

    public
}
