package com.vct.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.vct.entity.User;

import java.time.Instant;
import java.util.logging.Logger;

public class TokenService {

    public static String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("senha123");
            return JWT.create()
                    .withIssuer("vct-app")
                    .withSubject(user.getName())
                    .withExpiresAt(Instant.now().plusSeconds(60))
                    .withClaim("email", user.getEmail())
                    .sign(algorithm);
        }
        catch (JWTCreationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
