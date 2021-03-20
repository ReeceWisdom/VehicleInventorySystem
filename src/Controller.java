import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.Configuration.ClassList;

/**
 * public class managing creating, configuring, mapping & starting the server
 * @author Reece
 */
public class Controller
{
	public static void main(String[] args) throws Exception
	{
		Server server = new Server(8082); //jetty server object listening on port 8082 --- http://localhost:8082/vehiclesdb/home
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("webapp");
		ctx.setContextPath("/vehiclesdb"); //declares path for the web site URL

		ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJatPattern", ".*/[^/]*jstl.*\\.jar$");
		ClassList classlist = ClassList.setServerDefault(server);
		classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
							"org.eclipse.jetty.annotations.AnnotationConfiguration");

		//adds the servlets to the web app
		ctx.addServlet("servlets.ServletHome", "/home");
		ctx.addServlet("servlets.ServletAddVehicle", "/add");
		ctx.addServlet("servlets.ServletDeleteVehicle", "/delete");
		ctx.addServlet("servlets.ServletUpdateVehicle", "/update");
		ctx.addServlet("servlets.ServletSearchVehicle", "/search");
		ctx.addServlet("servlets.ServletPriceVehicle", "/price");
		ctx.addServlet("servlets.ServletAPI", "/api");
		
		server.setHandler(ctx); //server handler is registered with server
		server.start(); //server started
		server.join(); //server joined
	}
}