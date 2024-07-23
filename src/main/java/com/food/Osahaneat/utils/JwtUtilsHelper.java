package com.food.Osahaneat.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;

// viết đoạn code liên quan tới jwt


@Component
public class JwtUtilsHelper {
    //lấy key
    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateJwtToken(String data) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        //giai ma key ra token
        String jws = Jwts.builder().subject(data).signWith(key).compact();
        return jws ;
    }

    public boolean verifyToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }
}
