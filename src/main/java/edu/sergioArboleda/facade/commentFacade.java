/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sergioArboleda.facade;
import com.mycompany.jpa.commentJPA;
import edu.sergioArboleda.dao.ServiceImpl;
import edu.sergioArboleda.dao.SingletonConnection;
import edu.sergioArboleda.exception.ConexionException;
import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author james
 */
public class commentFacade extends ServiceImpl<commentJPA>{
    public commentFacade() throws ConexionException {
        super(commentJPA.class);
        try{
             EntityManager em = SingletonConnection.getConnection();
            super.setEntityManager(em);
        }catch(Exception e){
            e.printStackTrace();
           throw new ConexionException("Problemas en la realizacion de conexion con la base de datos");
        }
    }
    
    @Override
    public List<commentJPA> findAll() {
        return super.findAll();
    }
}
