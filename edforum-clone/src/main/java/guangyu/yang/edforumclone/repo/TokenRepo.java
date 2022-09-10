package guangyu.yang.edforumclone.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import guangyu.yang.edforumclone.entities.Token;

public interface TokenRepo extends JpaRepository<Token, Long>{
    Optional<Token> findByTokenString(String tokenString);
}
