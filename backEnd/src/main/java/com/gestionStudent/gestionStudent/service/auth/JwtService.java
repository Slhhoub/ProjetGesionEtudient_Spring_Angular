package com.gestionStudent.gestionStudent.service.auth;

import com.gestionStudent.gestionStudent.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.io.Decoders;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY = "fe96204a6ccff291b1e48d405096f28a70b892f94ae3be3f647af3944d7c1efc";

    private SecretKey getsigininKey(){
        byte[] keyBetes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBetes);
    }

    public String genereToken(User user){
        String token = Jwts
                .builder()
                .subject(user.getUsername())
                .claim("first_name",user.getFirst_name())
                .claim("role",user.getRole())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ 24*60*60*1000))
                .signWith(getsigininKey())
                .compact();
        return token;
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getsigininKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public <T> T extractClaims(String token, Function<Claims,T> resolver){
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Date extractExpiration(String token) {
        return extractClaims(token,Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }
    public boolean isValid(String token, UserDetails user){
        String username=extractUsername(token);
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }




}
