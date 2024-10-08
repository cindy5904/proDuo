package org.example.authentificationservice.controller;

import org.example.authentificationservice.dto.LoginRequestDto;
import org.example.authentificationservice.dto.LoginResponseDto;
import org.example.authentificationservice.dto.RegisterRequestDto;
import org.example.authentificationservice.dto.RegisterResponseDto;
import org.example.authentificationservice.entity.UserApp;
import org.example.authentificationservice.exception.NotFoundException;
import org.example.authentificationservice.exception.UserAlreadyExistException;
import org.example.authentificationservice.security.JWTGenerator;
import org.example.authentificationservice.service.UserAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserAppController {
    private final AuthenticationManager authenticationManager;

    private final UserAppService userAppService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator generator;

    public UserAppController(AuthenticationManager authenticationManager, UserAppService userAppService, PasswordEncoder passwordEncoder, JWTGenerator generator) {
        this.authenticationManager = authenticationManager;
        this.userAppService = userAppService;
        this.passwordEncoder = passwordEncoder;
        this.generator = generator;
    }


    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = generator.generateToken(authentication);
            return ResponseEntity.ok(LoginResponseDto.builder().token(token).build());
        } catch (Exception ex) {
            // Log the exception for better debugging
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return ResponseEntity.status(401).body("Invalid credentials or other authentication issues");
        }
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDTO) throws UserAlreadyExistException {
        // Encoder le mot de passe avant d'enregistrer l'utilisateur
        registerRequestDTO.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        UserApp userApp = userAppService.enregistrerUtilisateur(registerRequestDTO);
        return ResponseEntity.ok(RegisterResponseDto.builder().email(userApp.getEmail()).name(userApp.getName()).role(userApp.getRole().ordinal()).build());
    }
    @PostMapping("logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Déconnexion réussie");
    }
}
