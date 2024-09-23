package com.loiane.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loiane.exception.RecordNotFoundException;
import com.loiane.model.Course;
import com.loiane.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Validated
@Service
public class courseService {

    private final CourseRepository courseRepository;

    public courseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public @ResponseBody List<Course> list() {
        return courseRepository.findAll();
    }

    public Course findById(@PathVariable @NotNull @Positive Long id ) {
        return courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Course create(@Valid Course course) {
        return courseRepository.save(course);
    }

    public Course update(@NotNull @Positive Long id, @Valid Course Course) {
         return courseRepository.findById(id)
            .map(RecordFound -> {
                RecordFound.setName(Course.getName());
                RecordFound.setCategory(Course.getCategory());
                return courseRepository.save(RecordFound);
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {

        courseRepository.delete(courseRepository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException(id)));

         courseRepository.findById(id)
             .map(RecordFound -> {
                 courseRepository.deleteById(id);
                 return true;
             })
             .orElseThrow(() -> new RecordNotFoundException(id));
     }

    
}
