package com.example.demo.rest.service;

import com.example.demo.rest.model.Course;
import com.example.demo.rest.model.Student;
import com.example.demo.rest.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository repo;

    @Transactional
    public Student addStudent(Student s){
        return repo.save(s);
    }

    @Transactional
    public void updateStudent(Student s, Long id){
        Student student = repo.findById(id).get();
        student.setName(s.getName());
        student.setAge(s.getAge());
        student.setCourses(s.getCourses());
        repo.save(student);
    }

    @Transactional
    public void deleteStudent(Long id){
        repo.deleteById(id);
    }

    public List<Student> getAllStudents(){
        //collect the iteration student to a list using steam akshata
       return (List<Student>) repo.findAll();
    }

//    public List<Student> getStudentForCourse(Long id){
//        return repo.findByCourseId(id);
//    }


    public Optional<Student> getStudent(Long studentId) {
        return repo.findById(studentId);
    }

    public Set<Course> getCoursesOfStudent(Long studentId) {
        return repo.findById(studentId).get().getCourses();
    }

    public Set<Student> getAllstudents() {
        Set<Student> a = new HashSet<>();
         repo.findAll().iterator().forEachRemaining(t->a.add(t));
         return a;
    }
}
