package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.AllowanceVariant;

public interface AllowanceVariantDao extends GenericDao<AllowanceVariant, Long> {
	boolean insertAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException;
	boolean modifyAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException;
	boolean removeAllowanceVariant(AllowanceVariant allowanceVariant) throws DataException;
	AllowanceVariant findAllowanceVariantById(int allowanceVariantId) throws DataException;
	List<AllowanceVariant> retrieveAllowanceVariants() throws DataException;
	AllowanceVariant retrieveAllowanceVariantByDesignation(int designationId) throws DataException;
}
