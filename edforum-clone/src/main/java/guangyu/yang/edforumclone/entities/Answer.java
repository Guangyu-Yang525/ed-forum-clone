package guangyu.yang.edforumclone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.Instant;
import lombok.Data;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long answerId;
    @NotEmpty
    private String content;
    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "postId")
    private Post post;
    private Boolean accepeted = false;
    @Positive
    private int likes = 0;
    private Instant answerDate;
}
