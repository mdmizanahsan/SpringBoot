package com.mizan.journelApp.controller;


import com.mizan.journelApp.Entity.JournelEntity;
import com.mizan.journelApp.service.JournelEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journel")
public class JournelEntityController {

    @Autowired
    private JournelEntryService journelEntryService;

    @PostMapping
    public ResponseEntity<JournelEntity> addEntity(@RequestBody JournelEntity journelEntity) {
       try {
           journelEntryService.saveEntry(journelEntity);
           return new ResponseEntity<>(journelEntity, HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<JournelEntity> all = journelEntryService.getAll();
        if (all !=null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournelEntity> findById(@PathVariable Long id) {
       Optional<JournelEntity> journelEntity = journelEntryService.findById(id);
        if (journelEntity.isPresent()) {
            return new ResponseEntity(journelEntity.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
         journelEntryService.deleteById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id , @RequestBody JournelEntity journelEntity) {
       JournelEntity old =  journelEntryService.findById(id).orElse(null);
       if (old != null ) {
           old.setTittle(journelEntity.getTittle() != null && !journelEntity.getTittle().equals("") ? old.getTittle() : journelEntity.getTittle());
           old.setContent(journelEntity.getContent() != null && !journelEntity.getContent().equals("") ? old.getContent() : journelEntity.getContent());
            journelEntryService.saveEntry(old);
            return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
