package br.com.milton.dao;

import br.com.milton.model.Usuario;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Nilson
 */
public class UsuarioDao extends DaoImpl<Usuario,Integer>{
    public Usuario getUsuario(String login){
        Usuario u=null;
        try{
            Query qry=getEntityManager().createQuery("select o from Usuario o where o.login=:login");
            qry.setParameter("login", login);
            qry.setMaxResults(1);
            
            u=(Usuario)qry.getSingleResult();
        }catch(NoResultException e){
            u=null;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            getEntityManager().close();
        }
        return u;
    }
}
