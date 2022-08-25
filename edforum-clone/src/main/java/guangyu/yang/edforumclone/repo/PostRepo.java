package guangyu.yang.edforumclone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import guangyu.yang.edforumclone.entities.Course;
import guangyu.yang.edforumclone.entities.Post;
import guangyu.yang.edforumclone.entities.User;

public interface PostRepo extends JpaRepository<Post, Long>{
    List<Post> findByCourse(Course course);
    List<Post> findByUser(User user);
}
