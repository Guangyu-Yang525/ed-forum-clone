package guangyu.yang.edforumclone.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;
    @NotBlank(message = "title cannot be empty")
    private String title;
    @NotBlank(message = "content cannot be empty")
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relatedUser", referencedColumnName = "userId")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relatedCourse", referencedColumnName = "courseId")
    private Course course;
    private Instant postTime;
}
