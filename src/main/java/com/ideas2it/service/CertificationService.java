package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Certification;

public interface CertificationService {

    /**
     * Add new Certification
     *
     * @return True or Fales
     */
    public boolean addCertification(Certification certification) throws DataException;

    /**
     * Update existing Certification
     *
     * @return True or Fales
     */
    public boolean updateCertification(Certification certification) throws DataException;

    /**
     * Search given Certification
     *
     * @return Certification
     */
    public Certification searchCertification(int certificationId) throws DataException;

    /**
     * Retrive All Certification
     *
     * @return list
     */
    public List<Certification> getCertifications() throws DataException;

    /**
     * Retrive All Certification for given userId
     *
     * @return list
     */
    public List<Certification> getCertificationByUser(long userId) throws DataException;
}
