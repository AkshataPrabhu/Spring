package com.example.demo.rest.controller;

import com.example.demo.rest.model.Course;
import com.example.demo.rest.model.Student;
import com.example.demo.rest.model.Teacher;
import com.example.demo.rest.service.CourseService;
import com.example.demo.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService service;
    @Autowired
    CourseService courseService;

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {

        Optional<Student> student = service.getStudent(studentId);
        if (student.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(student.get());
    }

    @PostMapping(consumes = {"application/json", "application/xml"},
            produces = {"application/json"})
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {

        Student s = service.addStudent(student);
        if (null == s) {
            return ResponseEntity.badRequest().build();
        }
        URI u = URI.create("/" + s.getId());
        return ResponseEntity.created(u).build();
    }

    @PutMapping(path = "/{studentId}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Object> updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        //todo handle not found cases
        service.updateStudent(student, studentId);
        return ResponseEntity.ok().build();
    }




    @GetMapping(path = "/{studentId}/course", produces = {"application/json"})
    public ResponseEntity<Set<Course>> getCoursesOfStudent(@PathVariable Long studentId) {
        //todo handle not found cases
        return ResponseEntity.ok().body(service.getCoursesOfStudent(studentId));
    }

    @GetMapping
    public ResponseEntity<Set<Student>> getAllstudent() {
        return ResponseEntity.ok().body(service.getAllstudents());
    }


}
