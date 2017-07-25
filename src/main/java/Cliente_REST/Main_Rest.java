package Cliente_REST;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by jrdis on 16/6/2017.
 */
public class Main_Rest {
    public Main_Rest ()
    {

    }
  public String getOut (String user) {
      Client client = Client.create();
      WebResource webResource = client
              .resource("http://localhost:4567/rest/articulos/"+user);

      ClientResponse response = webResource.accept("application/json")
              .get(ClientResponse.class);


      String output = response.getEntity(String.class);
      return output;
  }

 public void post ( MultivaluedMap formData)
  {
      Client client = Client.create();
      WebResource webResource = client
              .resource("http://localhost:4567/rest/addTextrest");
      ClientResponse response = webResource
              .type("application/x-www-form-urlencoded")
              .post(ClientResponse.class, formData);

  }

    }

