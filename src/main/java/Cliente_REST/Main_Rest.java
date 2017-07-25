package Cliente_REST;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import freemarker.template.Configuration;
import freemarker.template.Version;

import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by jrdis on 16/6/2017.
 */
public class Main_Rest {
    public static void main(String[] args) {
        try {
            staticFiles.location("templates");
            staticFiles.externalLocation(System.getProperty("java.io.tmpdir"));
            final Configuration configuration = new Configuration(new Version(2, 3, 0));
            configuration.setClassForTemplateLoading(Main_Rest.class, "/");


            enableDebugScreen();
            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://localhost:4567/rest/articulos/jdisla_dj@hotmail.com");

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

          /*  WebResource webResource2 = client
                    .resource("http://localhost:4567/rest/estudiantes/2");


            ClientResponse response2 = webResource2.accept("application/json")
                    .get(ClientResponse.class);


            WebResource webResource3 = client
                    .resource("http://localhost:4567/rest/estudiantes/2");


            ClientResponse response3 = webResource3.accept("application/json")
                    .get(ClientResponse.class);*/


            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);
            //   String output2 = response2.getEntity(String.class);
            System.out.println("Output from Server .... \n");
            System.out.println(output);
            //  System.out.println("---------------------------- \n");
            //   System.out.println("Output2 from Server .... \n");
            //  System.out.println(output2);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
