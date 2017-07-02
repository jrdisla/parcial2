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

            Spark.get("/Login", (request, response) -> {

                Template resultTemplate = configuration.getTemplate("templates/Login.ftl");
                StringWriter writer = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();

                resultTemplate.process(attributes, writer);
                return writer;
            });

        }

    private static void autorizado(Request request, Response response) {

        Session ses = request.session(true);
        Usuario user = ses.attribute("usuario");

        if(user == null){
            halt(401, "No Autorizado");
        }
    }

}
