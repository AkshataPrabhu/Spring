package com.example.demo.rest.controller;

import com.example.demo.rest.model.Course;
import com.example.demo.rest.model.Teacher;
import com.example.demo.rest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherService service;

    @GetMapping(path = "/{teacherId}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long teacherId) {

        Optional<Teacher> teacher = service.getTeacherById(teacherId);
        if(teacher.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(teacher.get());
    }

    @PostMapping(consumes = {"application/json", "application/xml"},
            produces = {"application/json"})
    public ResponseEntity<String> addNewTeacher(@RequestBody Teacher teacher) {
        //todo return id of the teacher added and set the responseentity
        service.addTeacher(teacher);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{teacherId}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Object> updateTeacher(@RequestBody Teacher teacher) {
        service.updateTeacher(teacher);
        return ResponseEntity.ok().build();
    }

//    @GetMapping(path = "/{teacherId}/course", produces = {"application/json"})
//    public ResponseEntity<Set<Course>> getCoursesOfTeacher(@PathVariable Long teacherId) {
//        return ResponseEntity.ok().body(service.getCoursesTaughtby(teacherId));
//    }

    @GetMapping
    public ResponseEntity<Set<Teacher>> getAllteacher() {
        return ResponseEntity.ok().body(service.getTeachers());
    }

}
