package com.example.demo.rest.repository;

import com.example.demo.rest.model.Course;
import com.example.demo.rest.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

   // public Set<Course> findByCourseName(Long id);

    List<Teacher> findAll();
    // public List<Teacher> findAll();
}
