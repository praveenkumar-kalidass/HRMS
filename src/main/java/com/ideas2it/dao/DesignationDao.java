package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Designation;

public interface DesignationDao extends GenericDao<Designation,Long> {
	boolean insertDesignation(Designation designation) throws DataException;
	boolean modifyDesignation(Designation designation) throws DataException;
	boolean removeDesignation(Designation designation) throws DataException;
	Designation findDesignationById(int designationId) throws DataException;
	List<Designation> retrieveDesignations() throws DataException;
	List<Designation> retrieveDesignationByDepartment(int departmentId) throws DataException;
}
