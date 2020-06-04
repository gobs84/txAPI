package services;

import java.util.ArrayList;
import java.util.List;

import models.Student;

public class StudentService {
	
	private static final List<Student> students= new ArrayList<Student>();
	
	static {
		students.add(new Student(1, "Gabriel", "Perez"));
		students.add(new Student(2, "Sebastian", "Parker"));
		students.add(new Student(3, "Peter", "Quill"));
	}
	 
	
    public List<Student> getStudents() {
    	return students;
    }
	
    public Student getStudent(int studentId) {
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
		student.setId(GenerateId());
		students.add(student);
		return student; 
	}
	
	public Student UpdateStudent(Student student) {
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
		for (Student studentTemp: students) {
			if(studentTemp.getId()== studentId) {
				students.remove(studentTemp);
				break;
			}
		}
	}
	
	private int GenerateId() {
		int id = 0;
		for (Student student: students) {
			if(student.getId()>id) {
				id = student.getId();
			}
		}
		return id+1;
	}
}
