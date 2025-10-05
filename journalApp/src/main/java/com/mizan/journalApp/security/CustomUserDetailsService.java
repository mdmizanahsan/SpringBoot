package com.mizan.journalApp.security;

import com.mizan.journalApp.entity.UserEntry;
import com.mizan.journalApp.repository.UserEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserEntryRepository userEntryRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     UserEntry user = (UserEntry) userEntryRepository.findByUsername(username)
             .orElseThrow( () -> new UsernameNotFoundException("User Not Found: " + username));

        return new User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );

    }
}
