package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Certification;

public interface CertificationDao extends GenericDao<Certification,Long>{
	List<Certification> retrieveCertificationsByUser(long userId) throws DataException;
	List<Certification> retrieveCertifications() throws DataException;
	Certification findCertificationById(int certificationId) throws DataException;
	boolean modifyCertification(Certification certification) throws DataException;
	boolean insertCertification(Certification certification) throws DataException;
}
