/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.holamuntorest;
import com.mycompany.jpa.datapacketJPA;
import edu.sergioArboleda.exception.ConexionException;
import edu.sergioArboleda.facade.datapacketFacade;
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
import org.o7planning.restfulcrud.model.datapacket;

/**
 *
 * @author james
 */
@Path("/datapackets")
public class datapacketServicio {
    
    // URI:
    // /contextPath/servletPath/datapackets  --> RETORNA LISTA DE ELEMENTOS DENTRO DE LA TABLA datapackets
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<datapacket> getStudent_JSON() throws ConexionException {
        List<datapacket> testsDTO = new ArrayList<datapacket>();
        datapacketFacade facade = null;

        facade = new datapacketFacade();
        List<datapacketJPA> tests = facade.findAll();
        for (datapacketJPA test : tests) {
            datapacket dto = new datapacket();
            dto.setLatitud(test.getLatitud());
            dto.setLongitud(test.getLongitud());
            dto.setDistancia(test.getDistancia());
            testsDTO.add(dto);
        }
        return testsDTO;
    }
    
    
    // URI:
    // /contextPath/servletPath/datapackets/{ID del objeto en especifico que buscas!}
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public datapacket getTest(@PathParam("id") String id) throws ConexionException {
        datapacketFacade facade = null;
        datapacket dto = null;
        facade = new datapacketFacade();
        datapacketJPA test = facade.get(Integer.parseInt(id));
        dto = new datapacket();
        dto.setLatitud(test.getLatitud());
        dto.setLongitud(test.getLongitud());
        dto.setDistancia(test.getDistancia());
        return dto;
        //REVISAR BIEN! No se si está funcionando este GET.
    }
    
    
    // URI:
    // /contextPath/servletPath/datapackets
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public datapacket addStudent(datapacket test) throws ConexionException {
        datapacketFacade facade = null;
        datapacket dto = null;
        facade = new datapacketFacade();
        datapacketJPA prueba = new datapacketJPA();
        prueba.setLatitud(test.getLatitud());
        prueba.setLongitud(test.getLongitud());
        prueba.setDistancia(test.getDistancia());
        facade.save(prueba);
        return dto;
    }
    
    
    // URI:
    // /contextPath/servletPath/datapackets
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public datapacket updateEmployee(datapacket test) throws ConexionException {
        datapacketFacade facade = null;
        datapacket dto = null;
        facade = new datapacketFacade();
        datapacketJPA prueba= new datapacketJPA();
        prueba.setLatitud(test.getLatitud());
        prueba.setLongitud(test.getLongitud());
        prueba.setDistancia(test.getDistancia());
        facade.update(prueba);
        return dto;
    }
    
    
    
    // URI:
    // /contextPath/servletPath/datapackets/{ID que deseas borrar!}
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteEmployee(@PathParam("id") String id) throws ConexionException {
        datapacketFacade facade = null;

        facade = new datapacketFacade();
        datapacketJPA test = facade.get(Integer.parseInt(id));
        facade.delete(test);
        //REVISAR BIEN! No se si está funcionando el delete.

    }
    
    
}
