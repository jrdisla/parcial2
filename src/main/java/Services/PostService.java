package Services;

import Logica.Articulo;
import Logica.Usuario;
import Manejadores.ManejadorArticulo;
import Manejadores.ManejadorUsuario;

import java.util.*;

/**
 * Created by cesarjose on 7/23/17.
 */
public class PostService {

    private static PostService instancia;
    private static List<Articulo> articuloList;

    private PostService()
    {
        articuloList = new ArrayList<Articulo>();
    }

    public static PostService getInstancia()
    {
        if(instancia==null)
        {
            instancia = new PostService();
        }

        return instancia;
    }

    public Usuario getUsuario(String email) throws Exception{

        List<Usuario> usuarioList = ManejadorUsuario.getInstance().getAllObjects();
        System.out.println(usuarioList.size());
        return usuarioList.get(0);
        //return usuarioList.stream().filter(est -> est.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    public List<String> getAllArticulo (String username) throws Exception {
        List<Articulo> articulos = ManejadorArticulo.getInstance().getAllObjects();
        List<Articulo> aux = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (Articulo item: articulos
                ) {
            if(item != null && item.getUsuario().getEmail().equalsIgnoreCase(username))
            {
                list.add(item.getTitulo());
                list.add(item.getBody());
            }
        }

        //  list.add("hola1");
        //  list.add("hola2");
        return list;
    }

    public String postearArticulo(String msj)
    {
        Usuario usuario = ManejadorUsuario.getInstance().GetUser("cliente@gmail.com");
        Articulo articulo = new Articulo();

        articulo.setTitulo("Hello");
        articulo.setFecha(new Date());
        articulo.setBody(msj);
        articulo.setUsuario(usuario);

        try {
            ManejadorArticulo.getInstance().insertIntoDatabase(articulo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Inserted Succesfully";
    }
}
