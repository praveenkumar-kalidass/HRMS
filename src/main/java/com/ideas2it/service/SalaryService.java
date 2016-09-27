package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Salary;

public interface SalaryService {

    /**
     * GenerateSalary for given Dates
     *
     * @return list
     */
    public List<Salary> generateSalary(String fromDate, String toDate, int noDays)
            throws NumberFormatException, DataException;
}
