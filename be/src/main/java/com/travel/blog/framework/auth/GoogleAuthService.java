package com.travel.blog.framework.auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.travel.blog.repository.db.model.blog.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class GoogleAuthService {

    private final UserRepository repository;
    private final JwtService jwtService;

    public String processGoogleLogin(String idTokenString) {
        GoogleIdToken.Payload payload = verifyGoogleToken(idTokenString);

        String email = payload.getEmail();
        String name = (String) payload.get("name");

        User existingUser = repository.findByEmail(email)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setEmail(email);
                    newUser.setName(name);
                    repository.save(newUser);
                    return null;
                });

        return jwtService.generateToken(existingUser);
    }

    private GoogleIdToken.Payload verifyGoogleToken(String idTokenString) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
                    .setAudience(Collections.singletonList("43327956296-k8d9l5t2d1epjba7ajhf1nqcrka9k545.apps.googleusercontent.com"))
                    .build();

            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                return idToken.getPayload();
            } else {
                throw new RuntimeException("Invalid ID token.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Token verification failed", e);
        }
    }
}
