package com.cglia.student.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Student_project_information", catalog = "bhuvan")
public class StudentProjectEntity {
    @Id
    @Column(name = "project_Id", unique = true, nullable = false)
    private int projectId;

    @Column(name = "project_Name")
    private String projectName;
    @Column(name = "date_Of_Finish")
    private String dateOfFinish;

    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private List<StudentEntity> students = new ArrayList<>();

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(String dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
    
   
}
