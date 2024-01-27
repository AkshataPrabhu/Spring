package com.example.demo.rest.service;

import com.example.demo.rest.model.Course;
import com.example.demo.rest.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    @Transactional
    public void addCourse(Course c){
       repo.save(c);
    }

    @Transactional
    public Optional<Course> updateCourse(Course c, Long courseId){
        Optional<Course> course = repo.findById(courseId);
        if(course.isEmpty()){
            return null;
        }
        Course updateCourse = course.get();
        updateCourse.setCourseDescription(c.getCourseDescription());
        updateCourse.setCourseName(c.getCourseName());
      //  updateCourse.setTeacher(c.getTeacher());
        repo.save(updateCourse);
        return Optional.of(updateCourse);
    }

    @Transactional
    public void deleteCourse(Long id){
        repo.deleteById(id);
    }

    public Optional<Course> getCourse(Long id){
        return repo.findById(id);
    }
//    public List<Course> getCoursesByTeacher(Long id){
//        return repo.findByTeacherId(id);
//    }

    public List<Course> getAllCourses(){
        return (List<Course>) repo.findAll();
    }

    public Optional<Course> getCourseByName(String name) {
        return repo.findByCourseName(name);
    }
}
