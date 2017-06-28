import Logica.Usuario;
import Manejadores.ManejadorUsuario;

/**
 * Created by jrdis on 16/6/2017.
 */
public class Main {


    public static void main(String[] args) throws Exception {
        Usuario usuario = new Usuario("admin@admin", "admin", "admin", true, "admin");
        ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstance();
        manejadorUsuario.insertIntoDatabase(usuario);

    }
}
