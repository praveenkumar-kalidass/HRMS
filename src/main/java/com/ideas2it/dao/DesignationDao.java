package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Designation;

public interface DesignationDao extends GenericDao<Designation, Long> {

	/**
	 * Add new Designation
	 *
	 * @return True or Fales
	 */
	boolean insertDesignation(Designation designation) throws DataException;

	/**
	 * Update existing Designation
	 *
	 * @return True or Fales
	 */
	boolean modifyDesignation(Designation designation) throws DataException;

	/**
	 * Delete Designation
	 *
	 * @return True or Fales
	 */
	boolean removeDesignation(Designation designation) throws DataException;

	/**
	 * Search given Designation
	 *
	 * @return Designation
	 */
	Designation findDesignationById(int designationId) throws DataException;

	/**
	 * Retrive All Designation
	 *
	 * @return list
	 */
	List<Designation> retrieveDesignations() throws DataException;

	/**
	 * Retrive All Designation by given Department
	 *
	 * @return list
	 */
	List<Designation> retrieveDesignationByDepartment(int departmentId) throws DataException;
}
