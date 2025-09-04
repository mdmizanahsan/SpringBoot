package com.mizan.journelApp.service;


import com.mizan.journelApp.Entity.JournelEntity;
import com.mizan.journelApp.repository.JournelEntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournelEntryService {

    private static final Logger log = LoggerFactory.getLogger(JournelEntryService.class);
    @Autowired
    private JournelEntryRepository journelEntryRepository;


    public void saveEntry(JournelEntity journelEntity) {
        try {
            journelEntity.setDate(LocalDateTime.now());
            journelEntryRepository.save(journelEntity);
        } catch (Exception e) {
            log.error("Exception" , e);
        }
        return ;
    }

    // GET
     public List<JournelEntity> getAll() {
         return (List<JournelEntity>) journelEntryRepository.findAll();
     }
    // GET by ID
     public Optional<JournelEntity> findById(Long id) {
       return journelEntryRepository.findById(id);
     }  

     // Delete
/*
    public JournelEntity delete(Long id) {
        Optional<JournelEntity> journelEntity =  journelEntryRepository.findById(id);
        if(journelEntity.isPresent()) {
          journelEntryRepository.deleteById(id);
          System.out.println("Deleted successfully!");
        } else {
            System.out.println("Entity not found with id: " + id);
        }
        return null;
    }
*/
    // PUT
/*
    public JournelEntity updateById(JournelEntity journelEntity , Long id) {
       JournelEntity journelEntity1= journelEntryRepository.findById(id).orElse(null);
       if (journelEntity1 !=null) {
           journelEntity1.setTittle(journelEntity.getTittle() != null && !journelEntity.getTittle().equals("") ? journelEntity1.getTittle() : journelEntity.getTittle());
           journelEntity1.setContent(journelEntity.getContent() != null && !journelEntity.getContent().equals("") ? journelEntity1.getContent() : journelEntity.getContent());
       }
       return journelEntryRepository.save(journelEntity);
    }

*/
    public void deleteById(Long id) {
        journelEntryRepository.deleteById(id);
    }



}
