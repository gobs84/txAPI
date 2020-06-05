package txAPI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Class;
import services.ClassService;

@Path("/classes") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class ClassControllers {
	
	private ClassService _classService = new ClassService();
	
	@GET  
    public Response getClasses() {
        return Response.ok(_classService.getClasses()).build();   
    }
	
	@GET
	@Path("{classId}")
    public Response getClass(@PathParam("classId") int classId) {     
        return Response.ok(_classService.getClass(classId)).build();   
    }
	
	@POST
	public Response CreateClass(Class classO) {
		return Response.ok(_classService.CreateClass(classO)).build(); 
	}
	
	@PUT
	public Response UpdateClass(Class classO) {
		return Response.ok(_classService.UpdateClass(classO)).build();
	}
	
	@DELETE
	@Path("{classId}")
	public Response DeleteClass(@PathParam("classId") int classId) {
		_classService.DeleteClass(classId);
		return Response.ok("Class Deleted").build();
	}
}
