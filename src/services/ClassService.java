package services;

import java.util.ArrayList;
import java.util.List;

import models.Class;

public class ClassService {
private static final List<Class> classes= new ArrayList<Class>();
	
	static {
		classes.add(new Class(1, "Math", ""));
		classes.add(new Class(2, "History", ""));
		classes.add(new Class(3, "English", ""));
	}
	 
	
    public List<Class> getClasses() {
    	return classes;
    }
	
    public Class getClass(int classId) {
    	Class classO = new Class();
    	for (Class classTemp: classes) {
			if(classTemp.getId()== classId) {
				classO = classTemp;
				break;
			}
		}
        return classO;   
    }
	
	public Class CreateClass(Class classO) {
		classO.setId(GenerateId());
		classes.add(classO);
		return classO; 
	}
	
	public Class UpdateClass(Class classO) {
		for (Class classTemp: classes) {
			if(classTemp.getId()== classO.getId()) {
				classTemp.setTitle(classO.getTitle());
				classTemp.setDescription(classO.getDescription());
				break;
			}
		}
		return classO;
	}
	
	public Boolean DeleteClass(int classId) {
		Boolean flag = false;
		for (Class classTemp: classes) {
			if(classTemp.getId()== classId) {
				classes.remove(classTemp);
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	private int GenerateId() {
		int id = 0;
		for (Class classO: classes) {
			if(classO.getId()>id) {
				id = classO.getId();
			}
		}
		return id+1;
	}
}
