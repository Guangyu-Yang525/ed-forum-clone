package guangyu.yang.edforumclone.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guangyu.yang.edforumclone.entities.RegisterRequest;
import guangyu.yang.edforumclone.entities.User;
import guangyu.yang.edforumclone.repo.UserRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepo repo;
    private PasswordEncoder passwordEncoder;
    @Transactional
    public void signup(RegisterRequest request) {
        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encodePassword(request.getPassword()));
        newUser.setUsername(request.getUsername());
        repo.save(newUser);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
