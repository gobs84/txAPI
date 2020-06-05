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
	
    public Student getStudent(int studentId) {
    	List<Student> students = database.students;
    	Student student = new Student();
    	for (Student studentTemp: students) {
			if(studentTemp.getId()== studentId) {
				student = studentTemp;
				break;
			}
		}
        return student;   
    }
	
	public Student CreateStudent(Student student) {
		List<Student> students = database.students;
		student.setId(GenerateId());
		students.add(student);
		return student; 
	}
	
	public Student UpdateStudent(Student student) {
		List<Student> students = database.students;
		for (Student studentTemp: students) {
			if(studentTemp.getId()== student.getId()) {
				studentTemp.setFirstName(student.getFirstName());
				studentTemp.setLastName(student.getLastName());
				break;
			}
		}
		return student;
	}
	
	public void DeleteStudent(int studentId) {
		List<Student> students = database.students;
		for (Student studentTemp: students) {
			if(studentTemp.getId()== studentId) {
				students.remove(studentTemp);
				break;
			}
		}
	}
	
	private int GenerateId() {
		List<Student> students = database.students;
		int id = 0;
		for (Student student: students) {
			if(student.getId()>id) {
				id = student.getId();
			}
		}
		return id+1;
	}
}
