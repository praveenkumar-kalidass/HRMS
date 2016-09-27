package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Department;

public interface DepartmentDao extends GenericDao<Department, Long> {

	/**
	 * Add new Department
	 *
	 * @return True or Fales
	 */
	boolean insertDepartment(Department department) throws DataException;

	/**
	 * Update existing Department
	 *
	 * @return True or Fales
	 */
	boolean modifyDepartment(Department department) throws DataException;

	/**
	 * Delete Department
	 *
	 * @return True or Fales
	 */
	boolean removeDepartment(Department department) throws DataException;

	/**
	 * Search given Department
	 *
	 * @return Department
	 */
	Department findDepartment(int departmentId) throws DataException;

	/**
	 * Retrive All Department
	 *
	 * @return list
	 */
	List<Department> retrieveDepartments() throws DataException;
}
