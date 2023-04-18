package com.alexd.messager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

//Token generator and token parser.
public class JwtUtils {
    private static long expire = 604800;
    private static String secret = "1145141919810";

    public static String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public static Claims getClaimsByToken(String token) {
        String[] tokenParts = token.split(" ");
        String jwtToken = tokenParts[1];
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwtToken)
                .getBody();
    }

}
