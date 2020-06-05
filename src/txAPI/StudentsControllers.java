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

import services.ServiceException;
import services.StudentService;
import models.Student;

@Path("/students") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class StudentsControllers {
	private StudentService _studentService = new StudentService();
	
	@GET  
    public Response getStudents() {
		
        return Response.ok(_studentService.getStudents()).build();   
    }
	
	@GET
	@Path("{studentId}")
    public Response getStudent(@PathParam("studentId") int studentId) throws ServiceException {     
        return Response.ok(_studentService.getStudent(studentId)).build();   
    }
	
	@POST
	public Response CreateStudent(Student student) throws ServiceException {
		return Response.ok(_studentService.CreateStudent(student)).build(); 
	}
	
	@PUT
	public Response UpdateStudent(Student student) throws ServiceException {
		return Response.ok(_studentService.UpdateStudent(student)).build();
	}
	
	@DELETE
	@Path("{studentId}")
	public Response DeleteStudent(@PathParam("studentId") int studentId) throws ServiceException {
		_studentService.DeleteStudent(studentId);
		return Response.ok("Student Deleted").build();
	}
}
