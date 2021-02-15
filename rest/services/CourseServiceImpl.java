package com.springbootrest.rest.services;

import com.springbootrest.rest.dao.CourseDao;
import com.springbootrest.rest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

//    List<Course> list;
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
//        return this.list;
        return courseDao.findAll();
    }

    public Course getCourseById(int courseId){
//        Course c = null;
//        for(Course course : this.list){
//            if(course.getCourseId() == courseId){
//                c = course;
//                break;
//            }
//        }
//        return c;
        return courseDao.findById(courseId).get();
    }

    public Course addCourse(Course course){
//        list.add(course);
//        return course;
        courseDao.save(course);
        return course;
    }

    public Course updateCourse(Course course) {
//        for (Course course1 : list) {
//            if (course1.getCourseId() == course.getCourseId()) {
//                course1.setCourseName(course.getCourseName());
//                course1.setDescription(course.getDescription());
//            }
//        }
//        return course;
        courseDao.save(course);
        return course;
    }

    public void deleteCourse(int courseId){
//        for(Course course: list){
//            if(course.getCourseId() == courseId){
//                list.remove(course);
//            }
//        }
        courseDao.deleteById(courseId);
    }
}
