package com.example.demo.rest.repository;

import com.example.demo.rest.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

  //  public List<Student> findByCourseId(Long id);
}
