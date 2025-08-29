package com.mizan.journelApp.controller;


import com.mizan.journelApp.Entity.JournelEntity;
import com.mizan.journelApp.service.JournelEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journel")
public class JournelEntityController {

    @Autowired
    private JournelEntryService journelEntryService;



    @PostMapping
    public JournelEntity addEntity(@RequestBody JournelEntity journelEntity)
    {
         journelEntryService.saveEntry(journelEntity);

         return journelEntity;
    }

    @GetMapping
    public List<JournelEntity> getAll()
    {
        return journelEntryService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 if success
    public JournelEntity delete(@PathVariable Long id) {
        return journelEntryService.delete(id);
    }
}
