package guangyu.yang.edforumclone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.Instant;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tokenId;
    private String tokenString;
    @OneToOne
    @JoinColumn(name = "auth_user", referencedColumnName = "userId")
    private User user;
    private Instant expiryDate;
}
