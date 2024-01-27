package com.example.demo.rest.repository;

import com.example.demo.rest.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
//    public List<Course> findByTeacherId(Long id);

    public Optional<Course> findByCourseName(String name);
}
