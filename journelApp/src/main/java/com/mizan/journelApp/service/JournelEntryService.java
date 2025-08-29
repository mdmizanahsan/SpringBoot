package com.mizan.journelApp.service;


import com.mizan.journelApp.Entity.JournelEntity;
import com.mizan.journelApp.repository.JournelEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournelEntryService {

    @Autowired
    private JournelEntryRepository journelEntryRepository;


    public void saveEntry(JournelEntity journelEntity)
    {
        journelEntryRepository.save(journelEntity);
        return ;
    }

    // GET
     public List<JournelEntity> getAll()
     {
         return (List<JournelEntity>) journelEntryRepository.findAll();
     }

     // Delete

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
}
