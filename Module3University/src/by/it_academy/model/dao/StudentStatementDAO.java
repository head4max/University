package by.it_academy.model.dao;

import by.it_academy.model.entity4dao.StudentStatement;

public interface StudentStatementDAO extends AbstractDAO<StudentStatement> {
	
	boolean addFacultyRequest(int userID, int facultyID, int response);
}
