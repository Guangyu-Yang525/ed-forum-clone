package guangyu.yang.edforumclone.services;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
@Service
public class JwtUtil {
    private static final int expireInMs = 60 * 1000;
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
    public String generate(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireInMs))
                .signWith(key)
                .compact();
    }
    public boolean validate(String token) {
        return getEmail(token) != null && ! isExpired(token);
    }


    public String getEmail(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }
    
    public boolean isExpired(String token) {
        return getClaims(token).getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }


}
