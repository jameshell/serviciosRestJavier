/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.restfulcrud.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author james
 */
@XmlRootElement(name = "exam")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExamDTO {
    private int id;
    private double grade;
    private StudentDTO estudiante;
    private TestDTO test;

    public StudentDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(StudentDTO estudiante) {
        this.estudiante = estudiante;
    }

    public TestDTO getTest() {
        return test;
    }

    public void setTest(TestDTO test) {
        this.test = test;
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
        return "ExamDTO{" + "id=" + id + ", grade=" + grade + ", estudiante=" + estudiante + ", test=" + test + '}';
    }
    
}
