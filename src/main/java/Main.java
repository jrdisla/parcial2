import Logica.Usuario;
import Manejadores.ManejadorUsuario;
import org.h2.tools.Server;

import java.io.File;
import java.sql.SQLException;

/**
 * Created by jrdis on 16/6/2017.
 */
public class Main {
    public static File uploadDir = new File("./src/main/resources/public/uploads");
    public static File DowDir = new File("./src/main/resources/public/do");
    public static void main(String[] args) throws Exception {
     //   Usuario usuario = new Usuario("admin@admin", "admin", "admin", true, "admin");
    //    ManejadorUsuario manejadorUsuario = ManejadorUsuario.getInstance();
    //    manejadorUsuario.insertIntoDatabase(usuario);

        try
        {
            Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
            uploadDir.createNewFile();
        DowDir.createNewFile();
      Rutas.StartProyect(uploadDir,DowDir);

    }
}
