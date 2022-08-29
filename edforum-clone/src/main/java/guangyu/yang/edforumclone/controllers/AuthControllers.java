package guangyu.yang.edforumclone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guangyu.yang.edforumclone.entities.RegisterRequest;
import guangyu.yang.edforumclone.services.AuthService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthControllers {
    
    private final AuthService authService;

    @PostMapping(value="/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest request) {
        authService.signup(request);
        return new ResponseEntity<>("Created User", HttpStatus.OK);
    }

}
