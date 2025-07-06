package com.travel.blog.framework.auth;

import com.travel.blog.framework.auth.data.GoogleLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final GoogleAuthService googleAuthService;

    @PostMapping("/google")
    public ResponseEntity<?> loginWithGoogle(@RequestBody GoogleLoginRequest request) {
        String jwt = googleAuthService.processGoogleLogin(request.getIdToken());
        return ResponseEntity.ok(Map.of("jwt", jwt));
    }
}