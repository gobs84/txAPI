/**
 * 
 */
package models;

/**
 * @author gps97
 *
 */
public class Assignment {
	public int id;
	public int classId;
	public int studentId;
	
	public Assignment() {	
	}
	
	public Assignment(int id, int classId, int studentId) {
		super();
		this.id = id;
		this.classId = classId;
		this.studentId = studentId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
