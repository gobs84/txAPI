package models;

public class Student {
	private Long studentId;
	private String firstname;
	private String lastname;
	
	public Student() {	
	}
	
	public Student(Long id, String username, String password) {
		super();
		this.studentId = id;
		this.firstname = username;
		this.lastname = password;
	}
	
	public Long getId() {
		return studentId;
	}
	public void setId(Long id) {
		this.studentId = id;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
}
