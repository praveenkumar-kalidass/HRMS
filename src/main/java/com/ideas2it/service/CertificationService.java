package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Certification;

public interface CertificationService {

    /**
     * Add new Certification
     *
     * @return True or False
     */
    public boolean addCertification(Certification certification) throws DataException;

    /**
     * Update existing Certification
     *
     * @return True or False
     */
    public boolean updateCertification(Certification certification) throws DataException;

    /**
     * Search given Certification
     *
     * @return Certification
     */
    public Certification searchCertification(int certificationId) throws DataException;

    /**
     * Retrieve All Certifications
     *
     * @return list
     */
    public List<Certification> getCertifications() throws DataException;

    /**
     * Retrieve All Certifications for given userId
     *
     * @return list
     */
    public List<Certification> getCertificationByUser(long userId) throws DataException;
}
