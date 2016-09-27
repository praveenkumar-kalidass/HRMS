package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Department;

public interface DepartmentService {

    /**
     * Add new Department
     *
     * @return True or Fales
     */
    public boolean addDepartment(Department department) throws DataException;

    /**
     * Update existing Department
     *
     * @return True or Fales
     */
    public boolean updateDepartment(Department department) throws DataException;

    /**
     * Delete Department
     *
     * @return True or Fales
     */
    public boolean deleteDepartment(int departmentId) throws DataException;

    /**
     * Search given Department
     *
     * @return Department
     */
    public Department searchDepartment(int departmentId) throws DataException;

    /**
     * Retrive All Department
     *
     * @return list
     */
    public List<Department> retriveDepartments() throws DataException;
}
