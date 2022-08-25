package guangyu.yang.edforumclone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long starId;
    @ManyToOne
    @JoinColumn(name = "observer", referencedColumnName = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "postId")
    private Post post;
}
