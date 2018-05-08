package com.mycompany.jpa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
  CREATE TABLE `javahelps`.`student` 
  ( `student_id` SERIAL NOT NULL , 
      `student_name` VARCHAR(50) NOT NULL , 
      `student_age` INT NOT NULL , 
       PRIMARY KEY (`student_id`)
  );
*/
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @Column(name = "student_id", unique = true)
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;
    
    @Column(name = "student_lastname", nullable = false)
    private String lastName;

    @Column(name = "student_age", nullable = false)
    private int age;
    
    @Column(name = "student_email", nullable = false)
    private String email;
    
    @OneToMany(mappedBy="student")
    private List<Exam> exams;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", email=" + email + ", exams=" + exams + '}';
    }

    
}