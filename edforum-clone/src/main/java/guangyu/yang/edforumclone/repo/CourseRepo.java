package guangyu.yang.edforumclone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import guangyu.yang.edforumclone.entities.Course;
import guangyu.yang.edforumclone.entities.User;

public interface CourseRepo extends JpaRepository<Course, Long>{
    List<Course> findByName(String name);
    List<Course> findByUser(User user);
}
