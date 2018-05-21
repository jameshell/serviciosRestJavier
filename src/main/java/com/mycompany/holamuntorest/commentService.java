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
import com.mycompany.jpa.commentJPA;
import org.o7planning.restfulcrud.model.comment;
import edu.sergioArboleda.facade.commentFacade;


/**
 *
 * @author james
 */
@Path("/comments")
public class commentService {
    // URI:
    // /contextPath/servletPath/datapackets  --> RETORNA LISTA DE ELEMENTOS DENTRO DE LA TABLA datapackets
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<comment> getDogJson() throws ConexionException {
        List<comment> testsDTO = new ArrayList<comment>();
        commentFacade facade = null;

        facade = new commentFacade();
        List<commentJPA> tests = facade.findAll();
        for (commentJPA test : tests) {
            comment dto = new comment();
            dto.setUsuario(test.getUsuario());
            dto.setDescripcion(test.getDescripcion());
            testsDTO.add(dto);
        }
        return testsDTO;
    }
    
}
