package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.AllowanceVariant;

public interface AllowanceVariantService {

    /**
     * Add New AllowanceVariant
     *
     * @return True or False
     */
    public boolean addAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException;

    /**
     * Update AllowanceVariant
     *
     * @return True or False
     */
    public boolean updateAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException;

    /**
     * Delete AllowanceVariant
     *
     * @return True or False
     */
    public boolean deleteAllowanceVariant(int allowanceVariantId) throws DataException;

    /**
     * Search AllowanceVariant by Id
     *
     * @return AllowanceVarient
     */
    public AllowanceVariant searchAllowanceVariant(int allowanceVariantId) throws DataException;

    /**
     * Get AllowanceVariants
     *
     * @return List
     */
    public List<AllowanceVariant> getAllowanceVariants() throws DataException;

    /**
     * Search AllowanceVariant by given Designation
     *
     * @return AllowanceVarient
     */
    public AllowanceVariant getAllowanceVariantByDesignation(int designationId) throws DataException;
}
