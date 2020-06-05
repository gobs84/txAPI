package models;

import java.util.ArrayList;
import java.util.List;

public class MockDB {
	
	private static MockDB _instance;
	public List<Class> classes;
	public List<Student> students;
	public List<Assignment> assignments;
	
	private MockDB()
    {
        Initiate();
    }

    private void Initiate()
    {
        classes= new ArrayList<Class>();
        students= new ArrayList<Student>();
        assignments= new ArrayList<Assignment>();
        Populate();
    }
	
	public static MockDB Instance()
    {
            if (_instance == null)
            {
                _instance = new MockDB();
            }
            return _instance;
    }
	
	private void Populate() {
		classes.add(new Class(1, "Math", ""));
		classes.add(new Class(2, "Chemistry", "Studies element composition"));
		classes.add(new Class(3, "English", "Studies the gramathic and syntax of the language"));
		classes.add(new Class(4, "Physics", "Studies the natural Phenomenoms"));
		
		students.add(new Student(1, "Anthony", "Stark"));
		students.add(new Student(2, "Peter", "Parker"));
		students.add(new Student(3, "Peter", "Quill"));
		students.add(new Student(4, "Carol", "Danvers"));
		students.add(new Student(5, "Wanda", "Maximoff"));
		students.add(new Student(6, "Natasha", "Romanoff"));
		students.add(new Student(7, "Steve", "Rogers"));
		students.add(new Student(8, "Stephen", "Strange"));
		
		assignments.add(new Assignment(1, 1, 1));
		assignments.add(new Assignment(2, 1, 2));
		assignments.add(new Assignment(3, 1, 3));
		assignments.add(new Assignment(4, 1, 4));
		assignments.add(new Assignment(5, 2, 5));
		assignments.add(new Assignment(6, 2, 6));
		assignments.add(new Assignment(7, 2, 7));
		assignments.add(new Assignment(8, 2, 8));
		assignments.add(new Assignment(9, 3, 1));
		assignments.add(new Assignment(10, 3, 3));
		assignments.add(new Assignment(11, 3, 5));
		assignments.add(new Assignment(12, 3, 7));
		assignments.add(new Assignment(13, 4, 2));
		assignments.add(new Assignment(14, 4, 4));
		assignments.add(new Assignment(15, 4, 6));
		assignments.add(new Assignment(16, 4, 8));
	}
}
