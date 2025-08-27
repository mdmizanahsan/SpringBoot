package com.mizan.journelApp.service;


import com.mizan.journelApp.repository.JournelEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournelEntryService {

    @Autowired
    private JournelEntryRepository journelEntryRepository;


    public void saveEntry()
    {

    }
}
