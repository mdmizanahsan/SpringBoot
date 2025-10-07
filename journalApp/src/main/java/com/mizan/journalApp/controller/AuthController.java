package com.mizan.journalApp.controller;

import com.mizan.journalApp.dto.LoginRequestDTO;
import com.mizan.journalApp.dto.LoginResponseDTO;
import com.mizan.journalApp.dto.UserRequestDTO;
import com.mizan.journalApp.dto.UserResponseDTO;
import com.mizan.journalApp.repository.UserEntryRepository;
import com.mizan.journalApp.security.JwtUtil;
import com.mizan.journalApp.service.UserEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final UserEntryService userEntryService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserEntryRepository userEntryRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody UserRequestDTO dto) {
        if (userEntryRepository.findByUsername(dto.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userEntryService.createUser(dto), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        UserDetails user = (UserDetails) auth.getPrincipal();
        String token = jwtUtil.generateToken(user.getUsername());

        LoginResponseDTO response = new LoginResponseDTO();
        response.setUsername(dto.getUsername());
        response.setMessage(token); // ✅ send token as message or create field `token`

        return ResponseEntity.ok(response);
    }
}
