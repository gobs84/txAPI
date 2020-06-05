package services;

import java.util.List;

import models.MockDB;
import models.Student;

public class StudentService {

	public MockDB database;

	public StudentService() {
		database = MockDB.Instance();
	}

	public List<Student> getStudents() {
		List<Student> students = database.students;
		return students;
	}

	public Student getStudent(int studentId) throws ServiceException {
		Boolean found = false;
		List<Student> students = database.students;
		Student student = new Student();
		for (Student studentTemp : students) {
			if (studentTemp.getId() == studentId) {
				student = studentTemp;
				found = true;
				break;
			}
		}
		if (!found) {
			throw new ServiceException(404, "Student not found");
		}
		return student;
	}

	public Student CreateStudent(Student student) throws ServiceException {
		try {
			List<Student> students = database.students;
			student.setId(GenerateId());
			students.add(student);
		} catch (Exception e) {
			throw new ServiceException(500, "Couldn't create Students: " + e);
		}
		return student;
	}

	public Student UpdateStudent(Student student) throws ServiceException {
		try {
			Boolean found = false;
			List<Student> students = database.students;
			for (Student studentTemp : students) {
				if (studentTemp.getId() == student.getId()) {
					studentTemp.setFirstName(student.getFirstName());
					studentTemp.setLastName(student.getLastName());
					found = true;
					break;
				}
			}
			if (!found) {
				throw new ServiceException(404, "Student not found");
			}
		} catch (Exception e) {
			throw new ServiceException(500, "Couldn't update Students: " + e);
		}
		return student;
	}

	public void DeleteStudent(int studentId) throws ServiceException {
		Boolean found = false;
		List<Student> students = database.students;
		for (Student studentTemp : students) {
			if (studentTemp.getId() == studentId) {
				students.remove(studentTemp);
				found = true;
				break;
			}
		}
		if (!found) {
			throw new ServiceException(404, "Student not found");
		}
	}

	private int GenerateId() {
		List<Student> students = database.students;
		int id = 0;
		for (Student student : students) {
			if (student.getId() > id) {
				id = student.getId();
			}
		}
		return id + 1;
	}
}
