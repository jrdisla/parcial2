package Soap;

/**
 * Created by cesarjose on 7/25/17.
 */

import Services.PostService;
import com.sun.net.httpserver.HttpContext;
import org.eclipse.jetty.http.spi.HttpSpiContextHandler;
import org.eclipse.jetty.http.spi.JettyHttpContext;
import org.eclipse.jetty.http.spi.JettyHttpServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import javax.xml.ws.Endpoint;
import java.lang.reflect.Method;

public class SoapArranque {

    public static void init() throws Exception {

        //inicializando el servidor
        Server server = new Server(7777);
        ContextHandlerCollection contextHandlerCollection = new ContextHandlerCollection();
        server.setHandler(contextHandlerCollection);
        server.start();

        HttpContext context = build(server, "/ws");
        PostServicesSoap wsa = new PostServicesSoap();
        Endpoint endpoint = Endpoint.create(wsa);
        endpoint.publish(context);

        // access wsdl on http://localhost:7777/ws/PostServicesSoap?wsdl

    }

    private static HttpContext build(Server server, String contextString) throws Exception {
        JettyHttpServer jettyHttpServer = new JettyHttpServer(server, true);
        JettyHttpContext ctx = (JettyHttpContext) jettyHttpServer.createContext(contextString);
        Method method = JettyHttpContext.class.getDeclaredMethod("getJettyContextHandler");
        method.setAccessible(true);
        HttpSpiContextHandler contextHandler = (HttpSpiContextHandler) method.invoke(ctx);
        contextHandler.start();
        return ctx;
    }
}
