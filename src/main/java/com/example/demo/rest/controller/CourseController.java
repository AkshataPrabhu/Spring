package com.example.demo.rest.controller;

import com.example.demo.rest.model.Course;
import com.example.demo.rest.model.Student;
import com.example.demo.rest.model.Teacher;
import com.example.demo.rest.service.CourseService;
import com.example.demo.rest.service.StudentService;
import com.example.demo.rest.service.TeacherService;
import org.hibernate.sql.results.graph.collection.internal.SelectEagerCollectionAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @GetMapping(path = "/{courseId}")
    public ResponseEntity<Course> getCourseFor(@PathVariable Long courseId) {

        Optional<Course> course = courseService.getCourse(courseId);
        if(course.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(course.get());
    }


    @GetMapping(path="/")
    public ResponseEntity<Course> getCourseByName(@RequestParam(value = "name", defaultValue = "", required = false)
                                                      String name) {

        Optional<Course> course = courseService.getCourseByName(name);
        if(course.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(course.get());
    }

    @PostMapping(consumes = {"application/json", "application/xml"},
            produces = {"application/json"})
    public ResponseEntity<String> addNewCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        URI u = URI.create("/"+ course.getId()) ;
        return ResponseEntity.created(u).build();
    }

    @DeleteMapping(path="/{courseId}", produces = {"application/json"})
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok().build();
    }


    @PutMapping(path = "/{courseId}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Object> updateCourse(@PathVariable Long courseId,@RequestBody Course course) {
        Optional<Course> c = courseService.updateCourse(course, courseId);
        if(null==c){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

//    @GetMapping(path = "/{courseId}/teacher/{teacherId}", produces = {"application/json"})
//    public ResponseEntity<List<Course>> getTeachersForCourse(@PathVariable Long teacherId) {
//        return ResponseEntity.ok().body(courseService.getCoursesByTeacher(teacherId));
//    }

    @PutMapping(path = "/{courseId}/teacher/{teacherId}",  produces = {"application/json"})
    public ResponseEntity<Object> updateCourseTeacher(@PathVariable Long teacherId, @PathVariable Long courseId){
        Teacher t = teacherService.getTeacherById(teacherId).get();
        Course c = courseService.getCourse(courseId).get();
        c.setTeacher(t);
        courseService.addCourse(c);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{courseId}/student/{studentId}", produces = {"application/json"})
    public ResponseEntity<Object> addCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student s = studentService.getStudent(studentId).get();
        Course c = courseService.getCourse(courseId).get();
        Set<Student> student = new HashSet<>();
        student.add(s);
        c.setStudents(student);
        courseService.addCourse(c);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse() {
        return ResponseEntity.ok().body(courseService.getAllCourses());
    }

}
