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

import models.Assignment;
import services.AssignmentService;

@Path("/assignments") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class AssignmentControllers {
	
	private AssignmentService _assignmentService = new AssignmentService();
	
	@GET
	@Path("classId/{classId}")
    public Response getClassAssignments(@PathParam("classId") int classId) {
        return Response.ok(_assignmentService.getClassStudents(classId)).build();   
    }
	
	@GET
	@Path("/studentId/{studentId}")
    public Response getStudentsAssignment(@PathParam("studentId") int studentId) {     
        return Response.ok(_assignmentService.getStudentClasses(studentId)).build();   
    }
	
	@POST
	public Response CreateAssignment(Assignment assignment) {
		return Response.ok(_assignmentService.CreateAssignment(assignment)).build(); 
	}
	
	@PUT
	public Response UpdateAssignment(Assignment assignment) {
		return Response.ok(_assignmentService.UpdateAssignment(assignment)).build();
	}
	
	@DELETE
	@Path("{assignmentId}")
	public Response DeleteAssignment(@PathParam("assignmentId") int assignmentId) {
		_assignmentService.DeleteAssignment(assignmentId);
		return Response.ok("Class Deleted").build();
	}
}
