package com.springbootrest.rest.services;

import com.springbootrest.rest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public List<Course> getCourses();
    public Course getCourseById(int courseId);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(int courseId);
}
