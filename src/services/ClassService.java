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
		List<Class> classes = database.classes;
		return classes;
	}

	public Class getClass(int classId) throws ServiceException {
		Boolean found = false;
		List<Class> classes = database.classes;
		Class classO = new Class();
		for (Class classTemp : classes) {
			if (classTemp.getId() == classId) {
				classO = classTemp;
				found = true;
				break;
			}
		}
		if(!found) {
			throw new ServiceException(404, "Class not found");
		}
		return classO;
	}

	public Class CreateClass(Class classO) throws ServiceException {
		try {
			List<Class> classes = database.classes;
			classO.setId(GenerateId());
			classes.add(classO);
		} catch (Exception e) {
			throw new ServiceException(500, "Couldn't create Class: " + e);
		}
		return classO;
	}

	public Class UpdateClass(Class classO) throws ServiceException {
		try {
			Boolean found = false;
			List<Class> classes = database.classes;
			for (Class classTemp : classes) {
				if (classTemp.getId() == classO.getId()) {
					classTemp.setTitle(classO.getTitle());
					classTemp.setDescription(classO.getDescription());
					found = true;
					break;
				}
			}
			if(!found) {
				throw new ServiceException(404, "Class not found");
			}
		} catch (Exception e) {
			throw new ServiceException(500, "Couldn't update Class: " + e);
		}
		return classO;
	}

	public Boolean DeleteClass(int classId) throws ServiceException {
		Boolean found = false;
		List<Class> classes = database.classes;
		Boolean flag = false;
		for (Class classTemp : classes) {
			if (classTemp.getId() == classId) {
				classes.remove(classTemp);
				flag = true;
				found = true;
				break;
			}
		}
		if(!found) {
			throw new ServiceException(404, "Class not found");
		}
		return flag;
	}

	private int GenerateId() {
		List<Class> classes = database.classes;
		int id = 0;
		for (Class classO : classes) {
			if (classO.getId() > id) {
				id = classO.getId();
			}
		}
		return id + 1;
	}
}
