package com.codexrealis.factus_backend.controller;

import com.codexrealis.factus_backend.model.AuthRequest;
import com.codexrealis.factus_backend.model.AuthResponse;
import com.codexrealis.factus_backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Cambiamos @RequestParam a @RequestBody para recibir el JSON
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> autenticar(@RequestBody AuthRequest authRequest) {
        try {
            AuthResponse authResponse = authService.autenticar(
                    authRequest.getClientId(),
                    authRequest.getClientSecret(),
                    authRequest.getUsername(),
                    authRequest.getPassword()
            );
            return ResponseEntity.ok(authResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
