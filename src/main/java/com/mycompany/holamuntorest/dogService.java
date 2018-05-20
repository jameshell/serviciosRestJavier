/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.holamuntorest;
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
import edu.sergioArboleda.exception.ConexionException;
import com.mycompany.jpa.dogJPA;
import org.o7planning.restfulcrud.model.dog;
import edu.sergioArboleda.facade.dogFacade;


/**
 *
 * @author james
 */
@Path("/dogs")
public class dogService {
    // URI:
    // /contextPath/servletPath/datapackets  --> RETORNA LISTA DE ELEMENTOS DENTRO DE LA TABLA datapackets
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<dog> getDogJson() throws ConexionException {
        List<dog> testsDTO = new ArrayList<dog>();
        dogFacade facade = null;

        facade = new dogFacade();
        List<dogJPA> tests = facade.findAll();
        for (dogJPA test : tests) {
            dog dto = new dog();
            dto.setBreed(test.getBreed());
            dto.setPersonality(test.getPersonality());
            dto.setEnergy(test.getEnergy());
            dto.setDescription(test.getDescription());
            testsDTO.add(dto);
        }
        return testsDTO;
    }
    
    
    
      
    // URI:
    // /contextPath/servletPath/datapackets/{ID del objeto en especifico que buscas!}
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public dog getDog(@PathParam("id") String id) throws ConexionException {
        dogFacade facade = null;
        dog dto = null;
        facade = new dogFacade();
        dogJPA test = facade.get(Integer.parseInt(id));
        dto = new dog();
        dto.setBreed(test.getBreed());
        dto.setPersonality(test.getPersonality());
        dto.setEnergy(test.getEnergy());
        dto.setDescription(test.getDescription());
        return dto;
        //REVISAR BIEN! No se si está funcionando este GET.
    }
    
    
     // URI:
    // /contextPath/servletPath/datapackets
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public dog addDog(dog test) throws ConexionException {
        dogFacade facade = null;
        dog dto = null;
        facade = new dogFacade();
        dogJPA prueba = new dogJPA();
        prueba.setBreed(test.getBreed());
        prueba.setPersonality(test.getPersonality());
        prueba.setEnergy(test.getEnergy());
        prueba.setDescription(test.getDescription());
        facade.save(prueba);
        return dto;
    }
    
    
     // URI:
    // /contextPath/servletPath/datapackets
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public dog updateDog(dog test) throws ConexionException {
        dogFacade facade = null;
        dog dto = null;
        facade = new dogFacade();
        dogJPA prueba= new dogJPA();
        prueba.setBreed(test.getBreed());
        prueba.setPersonality(test.getPersonality());
        prueba.setEnergy(test.getEnergy());
        prueba.setDescription(test.getDescription());
        //Aca deberia poder poner la URL de la img para poder actualizarla mas tarde.
        facade.update(prueba);
        return dto;
    }
    
    // URI:
    // /contextPath/servletPath/datapackets/{ID que deseas borrar!}
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteDog(@PathParam("id") String id) throws ConexionException {
        dogFacade facade = null;

        facade = new dogFacade();
        dogJPA test = facade.get(Integer.parseInt(id));
        facade.delete(test);
        //REVISAR BIEN! No se si está funcionando el delete.

    }
    
    
    
    
}
