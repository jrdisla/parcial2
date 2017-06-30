/**
 * Created by cesarjose on 6/29/17.
 */

import Logica.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import Manejadores.*;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.Spark;
import java.io.StringWriter;
import java.util.*;
import static spark.Spark.*;


public class Rutas {

        public static void StartProyect() {

            staticFiles.location("/public");
            final Configuration configuration = new Configuration(new Version(2, 3, 0));
            configuration.setClassForTemplateLoading(Rutas.class, "/");

            Spark.get("/RegistrarUsuario", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/registrarUsuario.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                resultTemplate.process(attributes, writer);
                return writer;
            });
        }

}
