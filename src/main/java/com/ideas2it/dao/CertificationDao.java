package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Certification;

public interface CertificationDao extends GenericDao<Certification, Long> {

	/**
	 * Add new Certification
	 *
	 * @return True or Fales
	 */
	List<Certification> retrieveCertificationsByUser(long userId) throws DataException;

	/**
	 * Update existing Certification
	 *
	 * @return True or Fales
	 */
	List<Certification> retrieveCertifications() throws DataException;

	/**
	 * Search given Certification
	 *
	 * @return Certification
	 */
	Certification findCertificationById(int certificationId) throws DataException;

	/**
	 * Retrive All Certification
	 *
	 * @return list
	 */
	boolean modifyCertification(Certification certification) throws DataException;

	/**
	 * Retrive All Certification for given userId
	 *
	 * @return list
	 */
	boolean insertCertification(Certification certification) throws DataException;
}
