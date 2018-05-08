/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.holamuntorest;
import com.mycompany.jpa.Test;
import edu.sergioArboleda.exception.ConexionException;
import edu.sergioArboleda.facade.TestFacade;
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
import javax.ws.rs.core.Response;
import org.o7planning.restfulcrud.model.TestDTO;
/**
 *
 * @author james
 */

@Path("/tests")
public class TestServicio {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TestDTO> getStudent_JSON() throws ConexionException {
        List<TestDTO> testsDTO = new ArrayList<TestDTO>();
        TestFacade facade = null;

        facade = new TestFacade();
        List<Test> tests = facade.findAll();
        for (Test test : tests) {
            TestDTO dto = new TestDTO();
            dto.setCode(test.getIdTest());
            dto.setDescription(test.getDescription());
            testsDTO.add(dto);
        }

        return testsDTO;
    }

    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{empNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TestDTO getTest(@PathParam("id") String id) throws ConexionException {
        TestFacade facade = null;
        TestDTO dto = null;
        facade = new TestFacade();
        Test test = facade.get(Integer.parseInt(id));
        dto = new TestDTO();
        dto.setCode(test.getIdTest());
        dto.setDescription(test.getDescription());
        return dto;
        //REVISAR BIEN! No se si está funcionando este GET.
    }

    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TestDTO addStudent(TestDTO test) throws ConexionException {
        TestFacade facade = null;
        TestDTO dto = null;
        facade = new TestFacade();
        Test prueba = new Test();
        prueba.setIdTest(test.getCode());
        prueba.setDescription(test.getDescription());
        facade.save(prueba);
        return dto;
    }

    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TestDTO updateEmployee(TestDTO test) throws ConexionException {
        TestFacade facade = null;
        TestDTO dto = null;
        facade = new TestFacade();
        Test prueba= new Test();
        prueba.setIdTest(test.getCode());
        prueba.setDescription(test.getDescription());
        facade.update(prueba);
        return dto;
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteEmployee(@PathParam("id") String id) throws ConexionException {
        TestFacade facade = null;

        facade = new TestFacade();
        Test test = facade.get(Integer.parseInt(id));
        facade.delete(test);
        //REVISAR BIEN! No se si está funcionando el delete.

    }
}
