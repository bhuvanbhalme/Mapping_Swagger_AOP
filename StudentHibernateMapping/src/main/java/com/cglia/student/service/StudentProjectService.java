package com.cglia.student.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.student.entity.StudentEntity;
import com.cglia.student.entity.StudentProjectEntity;
import com.cglia.student.repository.StudentProjectRepository;

@Service
public class StudentProjectService {

    private final StudentProjectRepository studentProjectRepository;

    @Autowired
    public StudentProjectService(StudentProjectRepository studentProjectRepository) {
        this.studentProjectRepository = studentProjectRepository;
    }

    public List<StudentEntity> getStudentsByProjectId(int projectId) {
        Optional<StudentProjectEntity> project = studentProjectRepository.findById(projectId);
        if (project.isPresent()) {
            return project.get().getStudents();
        } else {
            return null;
        }
    }
}

