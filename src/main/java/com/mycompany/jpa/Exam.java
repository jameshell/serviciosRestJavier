/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author james
 */
@Entity
@Table(name = "exam")
public class Exam implements Serializable {
    @Id
    @Column(name = "exam_id", unique = false)
    private int id;
    
    @Column(name = "exam_grade", nullable = false)
    private double grade;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="test_id")
    private Test prueba;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Test getPrueba() {
        return prueba;
    }

    public void setPrueba(Test prueba) {
        this.prueba = prueba;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Exam{" + "id=" + id + ", grade=" + grade + ", student=" + student + ", prueba=" + prueba + '}';
    }

    
    
}
