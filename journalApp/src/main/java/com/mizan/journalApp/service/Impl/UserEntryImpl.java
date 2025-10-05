package com.mizan.journalApp.service.Impl;

import com.mizan.journalApp.dto.JournalResponseDTO;
import com.mizan.journalApp.dto.UserRequestDTO;
import com.mizan.journalApp.dto.UserResponseDTO;
import com.mizan.journalApp.entity.UserEntry;
import com.mizan.journalApp.repository.UserEntryRepository;
import com.mizan.journalApp.service.UserEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserEntryImpl implements UserEntryService {

    private final UserEntryRepository userEntryRepository;
    private final PasswordEncoder passwordEncoder;


     private UserResponseDTO mapToResponse(UserEntry user) {
       UserResponseDTO dto = new UserResponseDTO();
       dto.setId(user.getId());
       dto.setUsername(user.getUsername());
       dto.setJournalEntries(user.getJournalEntries().stream().map(j -> {
          JournalResponseDTO jdto = new JournalResponseDTO();
          jdto.setId(j.getId());
          jdto.setTitle(j.getTitle());
          jdto.setContent(j.getContent());
          jdto.setDate(j.getDate());
          return jdto;
       }).collect(Collectors.toList()));
       return dto;
     }

     @Override
     public UserResponseDTO createUser(UserRequestDTO dto) {
        UserEntry user= new UserEntry();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return mapToResponse(userEntryRepository.save(user));
     }

     @Override
     public List<UserResponseDTO> getAll() {
         List<UserEntry> users =  userEntryRepository.findAll();
         List<UserResponseDTO> dto = new ArrayList<>();
            for (UserEntry user : users) {
                dto.add(mapToResponse(user));
            }
            return dto;
     }

   /*     public List<UserResponseDTO> getAll() {
        List<UserResponseDTO> dtos = new ArrayList<>();
        userRepository.findAll().forEach(user -> dtos.add(mapToResponse(user)));
        return dtos;
      }
    */

    @Override
    public UserResponseDTO getById(Long id) {
        return mapToResponse(userEntryRepository.findById(id).orElse(null));
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
       UserEntry user =  userEntryRepository.findById(id).orElseThrow();
       user.setUsername(dto.getUsername());
       user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return mapToResponse(userEntryRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userEntryRepository.deleteById(id);
   }
}
