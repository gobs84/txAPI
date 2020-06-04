package txAPI;
import javax.ws.rs.Consumes; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response; 
import services.StudentService;

@Path("/students") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class StudentsControllers {
	@GET  
    public Response sayHello() {     
        return Response.ok("Hello World desde el API REST",MediaType.APPLICATION_JSON).build();   
    }
}
