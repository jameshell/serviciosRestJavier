package edu.sergioArboleda.facade;

import com.mycompany.jpa.Student;
import edu.sergioArboleda.dao.ServiceImpl;
import edu.sergioArboleda.dao.SingletonConnection;
import edu.sergioArboleda.exception.ConexionException;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Fabian Giraldo
 */
public class StudentFacade extends ServiceImpl<Student>{
    public StudentFacade() throws ConexionException {
        super(Student.class);
        try{
             EntityManager em = SingletonConnection.getConnection();
            super.setEntityManager(em);
        }catch(Exception e){
            e.printStackTrace();
           throw new ConexionException("Problemas en la realizacion de conexion con la base de datos");
        }
    }
    
    @Override
    public List<Student> findAll() {
        return super.findAll();
    }
}
