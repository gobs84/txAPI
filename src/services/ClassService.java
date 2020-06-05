package services;

import java.util.List;

import models.Class;
import models.MockDB;

public class ClassService {
	
	public MockDB database;
	
	public ClassService() {
		database = MockDB.Instance();
	}
	 
	
    public List<Class> getClasses() {
    	List<Class> classes= database.classes;
    	return classes;
    }
	
    public Class getClass(int classId) {
    	List<Class> classes= database.classes;
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
		List<Class> classes= database.classes;
		classO.setId(GenerateId());
		classes.add(classO);
		return classO; 
	}
	
	public Class UpdateClass(Class classO) {
		List<Class> classes= database.classes;
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
		List<Class> classes= database.classes;
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
		List<Class> classes= database.classes;
		int id = 0;
		for (Class classO: classes) {
			if(classO.getId()>id) {
				id = classO.getId();
			}
		}
		return id+1;
	}
}
