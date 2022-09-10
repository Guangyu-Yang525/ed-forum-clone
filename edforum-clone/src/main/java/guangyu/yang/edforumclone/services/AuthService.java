package guangyu.yang.edforumclone.services;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guangyu.yang.edforumclone.entities.RegisterRequest;
import guangyu.yang.edforumclone.entities.Token;
import guangyu.yang.edforumclone.entities.User;
import guangyu.yang.edforumclone.repo.TokenRepo;
import guangyu.yang.edforumclone.repo.UserRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepo repo;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;
    @Transactional
    public void signup(RegisterRequest request) {
        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encodePassword(request.getPassword()));
        newUser.setUsername(request.getUsername());
        repo.save(newUser);
        String tokenString = generateTokenForUser(newUser);
    }

    private String generateTokenForUser(User user) {
        String tokenString = UUID.randomUUID().toString();
        Token newToken = new Token();
        newToken.setUser(user);
        newToken.setTokenString(tokenString);
        return tokenString;
    }



    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
