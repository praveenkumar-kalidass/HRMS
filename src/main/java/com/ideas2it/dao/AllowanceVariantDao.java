package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.AllowanceVariant;

public interface AllowanceVariantDao extends GenericDao<AllowanceVariant, Long> {

    /**
     * Add New AllowanceVariant
     *
     * @return True or False
     */
    boolean insertAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException;

    /**
     * Update AllowanceVariant
     *
     * @return True or False
     */
    boolean modifyAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException;

    /**
     * Delete AllowanceVariant
     *
     * @return True or False
     */
    boolean removeAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException;

    /**
     * Search AllowanceVariant by Id
     *
     * @return AllowanceVarient
     */
    AllowanceVariant findAllowanceVariantById(int allowanceVariantId) throws DataException;

    /**
     * Get AllowanceVariants
     *
     * @return List
     */
    List<AllowanceVariant> retrieveAllowanceVariants() throws DataException;

    /**
     * Search AllowanceVariant by given Designation
     *
     * @return AllowanceVarient
     */
    AllowanceVariant retrieveAllowanceVariantByDesignation(int designationId) throws DataException;
}
