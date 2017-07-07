package Manejadores;

import Logica.Amigos;
import Logica.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by jrdis on 16/6/2017.
 */
public class ManejadorAmigos extends ManejadorDB<Amigos> {

    private static ManejadorAmigos instance;

    private ManejadorAmigos() { super(Amigos.class); }

    public static ManejadorAmigos getInstance() {
        if (instance == null) {
            instance = new ManejadorAmigos();
        }
        return instance;
    }


    public Amigos GetUser(String username)  {
        EntityManager em = getEntityManager();
        try {
            return (Amigos) em.createNamedQuery(Usuario.getUser)
                    .setParameter("email", username)
                    .getSingleResult();
        }
        catch (Exception ex) {
            return null;
        }
        finally {
            em.close();
        }
    }
}
