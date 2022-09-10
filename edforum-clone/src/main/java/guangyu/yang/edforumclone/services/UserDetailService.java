package guangyu.yang.edforumclone.services;

import java.util.Optional;

import javax.validation.constraints.Email;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import guangyu.yang.edforumclone.entities.User;
import guangyu.yang.edforumclone.repo.UserRepo;

public class UserDetailService implements UserDetailsService {
    BCryptPasswordEncoder passwordEncoder;
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            return new UserDetailWrapper(user.get());
        } else {
            throw new UsernameNotFoundException(email);
        }
    }
}
