package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Department;

public interface DepartmentDao extends GenericDao<Department, Long> {
	boolean insertDepartment(Department department) throws DataException;
	boolean modifyDepartment(Department department) throws DataException;
	boolean removeDepartment(Department department) throws DataException;
	Department findDepartment(int departmentId) throws DataException;
	List<Department> retrieveDepartments() throws DataException;
}
