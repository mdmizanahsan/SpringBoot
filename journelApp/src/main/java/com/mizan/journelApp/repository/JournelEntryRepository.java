package com.mizan.journelApp.repository;


import com.mizan.journelApp.Entity.JournelEntity;
import org.springframework.data.repository.CrudRepository;

public interface JournelEntryRepository extends CrudRepository<JournelEntity,Long> {


}
