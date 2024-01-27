package com.example.demo.rest.service;

import com.example.demo.rest.model.Course;
import com.example.demo.rest.model.Teacher;
import com.example.demo.rest.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository repo;

    Logger logger = Logger.getLogger(TeacherService.class.getName());
    public Optional<Teacher> getTeacherById(Long id) {
        Optional<Teacher> t = repo.findById(id);
        return t;
    }


    public Set<Course> getCoursesTaughtby(Long id) {
        Set<Course> courses = repo.findById(id).get().getCourses();
        return courses;
    }

    @Transactional
    public void addTeacher(Teacher teacher) {
        repo.save(teacher);

    }

    @Transactional
    public void deleteTeacher(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public boolean updateTeacher(Teacher t) {
        try {
            Teacher teacher = repo.getById(t.getId());
            if (teacher==null) {
                return false;
            }
            teacher.setCourses(t.getCourses());
            teacher.setName(t.getName());
            repo.save(teacher);
            return true;
        } catch (Exception ex){
            logger.severe("Failed to save teacher detials"+ t);
            return false;
        }
    }

    public Set<Teacher> getTeachers() {
        Set<Teacher> teachers = new HashSet<>();
        repo.findAll().iterator().forEachRemaining(t->teachers.add(t));
        return teachers;
    }

}
