package com.mizan.journalApp.service;

import com.mizan.journalApp.dto.UserRequestDTO;
import com.mizan.journalApp.dto.UserResponseDTO;
import com.mizan.journalApp.entity.UserEntry;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface UserEntryService {


    UserResponseDTO createUser(UserRequestDTO dto);

    List<UserResponseDTO> getAll();

    UserResponseDTO getById(Long id);

    UserResponseDTO updateUser(Long id, UserRequestDTO dto);

    void deleteUser(Long id);
}
