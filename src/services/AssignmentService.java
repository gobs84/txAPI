package services;

import java.util.ArrayList;
import java.util.List;

import models.Assignment;
import models.MockDB;
import models.Student;
import models.Class;

public class AssignmentService {

	public MockDB database;
	public StudentService _studentService = new StudentService();
	public ClassService _classService = new ClassService();

	public AssignmentService() {
		database = MockDB.Instance();
	}

	public List<Assignment> getStudents() {
		List<Assignment> assignments = database.assignments;
		return assignments;
	}

	public List<Student> getClassStudents(int id) throws ServiceException {
		List<Assignment> assignments = database.assignments;
		List<Student> studentsInClass = new ArrayList<Student>();
		for (Assignment assignmentTemp : assignments) {
			if (assignmentTemp.getClassId() == id) {
				studentsInClass.add(_studentService.getStudent(assignmentTemp.getStudentId()));
			}
		}
		if (studentsInClass.isEmpty()) {
			throw new ServiceException(404, "No students found in class");
		}
		return studentsInClass;
	}

	public List<Class> getStudentClasses(int id) throws ServiceException {
		List<Assignment> assignments = database.assignments;
		List<Class> studentClasses = new ArrayList<Class>();
		for (Assignment assignmentTemp : assignments) {
			if (assignmentTemp.getStudentId() == id) {
				studentClasses.add(_classService.getClass(assignmentTemp.getClassId()));
			}
		}
		if (studentClasses.isEmpty()) {
			throw new ServiceException(404, "Student has no classes");
		}
		return studentClasses;
	}

	public Assignment CreateAssignment(Assignment assignment) throws ServiceException {
		try {
			List<Assignment> assignments = database.assignments;
			assignment.setId(GenerateId());
			assignments.add(assignment);
		} catch (Exception e) {
			throw new ServiceException(500, "Couldn't create Assignment" + e);
		}
		return assignment;
	}

	public Assignment UpdateAssignment(Assignment assignment) throws ServiceException {
		try {
			Boolean found = false;
			List<Assignment> assignments = database.assignments;
			for (Assignment assignmentTemp : assignments) {
				if (assignmentTemp.getId() == assignment.getId()) {
					assignmentTemp.setClassId(assignment.getClassId());
					assignmentTemp.setStudentId(assignment.getStudentId());
					found = true;
					break;
				}
			}
			if(!found) {
				throw new ServiceException(404, "Assignment not found");
			}
		} catch (Exception e) {
			throw new ServiceException(500, "Couldn't create Assignment" + e);
		}
		return assignment;
	}

	public void DeleteAssignment(int assignmentId) throws ServiceException {
		Boolean found = false;
		List<Assignment> assignments = database.assignments;
		for (Assignment assignmentTemp : assignments) {
			if (assignmentTemp.getId() == assignmentId) {
				assignments.remove(assignmentTemp);
				found = true;
				break;
			}
		}
		if(!found) {
			throw new ServiceException(404, "Assignment not found");
		}
	}

	public void DeleteStudentAssignments(int studentId) {
		List<Assignment> assignments = database.assignments;
		for (Assignment assignmentTemp : assignments) {
			if (assignmentTemp.getStudentId() == studentId) {
				assignments.remove(assignmentTemp);
			}
		}
	}

	public void DeleteClassAssignments(int classId) {
		List<Assignment> assignments = database.assignments;
		for (Assignment assignmentTemp : assignments) {
			if (assignmentTemp.getClassId() == classId) {
				assignments.remove(assignmentTemp);
			}
		}
	}

	private int GenerateId() {
		List<Assignment> assignments = database.assignments;
		int id = 0;
		for (Assignment assignmentTemp : assignments) {
			if (assignmentTemp.getId() > id) {
				id = assignmentTemp.getId();
			}
		}
		return id + 1;
	}
}
