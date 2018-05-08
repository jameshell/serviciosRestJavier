/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.holamuntorest;
import com.mycompany.jpa.Exam;
import com.mycompany.jpa.Student;
import com.mycompany.jpa.Test;
import edu.sergioArboleda.exception.ConexionException;
import edu.sergioArboleda.facade.ExamFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.o7planning.restfulcrud.model.ExamDTO;
import org.o7planning.restfulcrud.model.StudentDTO;
import org.o7planning.restfulcrud.model.TestDTO;
/**
 *
 * @author james
 */
@Path("/examen")
public class ExamenServicio {
       @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<ExamDTO> getStudent_JSON() throws ConexionException {
        List<ExamDTO> examDTO = new ArrayList<ExamDTO>();
        ExamFacade facade = null;

        facade = new ExamFacade();
        List<Exam> examenes = facade.findAll();
        for (Exam exam : examenes) {
            ExamDTO dto = new ExamDTO();
            dto.setGrade(exam.getGrade());
            dto.setId(exam.getId());
            
            //Creo el estudiante para poder convertir un student a studentDTO
            StudentDTO estudiante = new StudentDTO();
            estudiante.setId(exam.getStudent().getId());
            estudiante.setName(exam.getStudent().getName());
            estudiante.setLastName(exam.getStudent().getLastName());
            estudiante.setAge(exam.getStudent().getAge());
            estudiante.setEmail(exam.getStudent().getEmail());
            dto.setEstudiante(estudiante);
            
            //Creo el test para poder convertir el test a testDTO
            TestDTO prueba = new TestDTO();
            prueba.setCode(exam.getPrueba().getIdTest());
            prueba.setDescription(exam.getPrueba().getDescription());
            dto.setTest(prueba);
            
            examDTO.add(dto);
        }

        return examDTO;
    }

    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{empNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ExamDTO getExam(@PathParam("id") String id) throws ConexionException {
        ExamFacade facade = null;
        ExamDTO dto = null;

        facade = new ExamFacade();
        Exam examen = facade.get(Integer.parseInt(id));
        dto = new ExamDTO();
        dto.setId(examen.getId());
        dto.setGrade(examen.getGrade());
        
           //Creo el estudiante para poder convertir un student a studentDTO
            StudentDTO estudiante = new StudentDTO();
            estudiante.setId(examen.getStudent().getId());
            estudiante.setName(examen.getStudent().getName());
            estudiante.setLastName(examen.getStudent().getLastName());
            estudiante.setAge(examen.getStudent().getAge());
            estudiante.setEmail(examen.getStudent().getEmail());
            dto.setEstudiante(estudiante);
            
            //Creo el test para poder convertir el test a testDTO
            TestDTO prueba = new TestDTO();
            prueba.setCode(examen.getPrueba().getIdTest());
            prueba.setDescription(examen.getPrueba().getDescription());
            dto.setTest(prueba);

        return dto;
    }

    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ExamDTO addExam(ExamDTO examen) throws ConexionException {
            ExamFacade facade = null;
            ExamDTO dto = null;

        facade = new ExamFacade();
        Exam examenJPA = new Exam();
        examenJPA.setId(examen.getId());
        examenJPA.setGrade(examen.getGrade());
        
        //Creamos estudiante para poder agregar la info del estudiante en el examen.
        Student student = new Student();
        student.setId(examen.getEstudiante().getId());
        student.setName(examen.getEstudiante().getName());
        student.setLastName(examen.getEstudiante().getLastName());
        student.setEmail(examen.getEstudiante().getEmail());
        student.setAge(examen.getEstudiante().getAge());
        examenJPA.setStudent(student);
        
        //Creamos test para poder agregar la info del test al examen.
        Test prueba = new Test();
        prueba.setIdTest(examen.getTest().getCode());
        prueba.setDescription(examen.getTest().getDescription());
        examenJPA.setPrueba(prueba);
     
        facade.save(examenJPA);
        return dto;
    }

    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ExamDTO updateExam(ExamDTO examen) throws ConexionException {
        ExamDTO dto = null;
        ExamFacade facade = null;
       facade = new ExamFacade();
       
       Exam examenJPA = new Exam();
        examenJPA.setId(examen.getId());
        examenJPA.setGrade(examen.getGrade());
        
        //Creamos estudiante para poder agregar la info del estudiante en el examen.
        Student student = new Student();
        student.setId(examen.getEstudiante().getId());
        student.setName(examen.getEstudiante().getName());
        student.setLastName(examen.getEstudiante().getLastName());
        student.setEmail(examen.getEstudiante().getEmail());
        student.setAge(examen.getEstudiante().getAge());
        examenJPA.setStudent(student);
        
        //Creamos test para poder agregar la info del test al examen.
        Test prueba = new Test();
        prueba.setIdTest(examen.getTest().getCode());
        prueba.setDescription(examen.getTest().getDescription());
        examenJPA.setPrueba(prueba);
        facade.update(examenJPA);

        return dto;
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteExam(@PathParam("id") String id) throws ConexionException {
        ExamFacade facade = null;

        facade = new ExamFacade();
        Exam exam = facade.get(Integer.parseInt(id));
        facade.delete(exam);

    }
}
