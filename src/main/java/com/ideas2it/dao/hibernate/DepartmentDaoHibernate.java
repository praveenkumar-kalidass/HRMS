package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.DepartmentDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Client;
import com.ideas2it.model.Department;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and
 * performs operation on manipulation of records associated with Departments.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-01
 */
@Repository("departmentDao")
@Transactional
public class DepartmentDaoHibernate extends GenericDaoHibernate<Department, Long> implements DepartmentDao {
	/**
     * Constructor to create a Generics-based version using Department as the entity
     */
    public DepartmentDaoHibernate() {
        super(Department.class);
    }

    /**
     * <p>
     * This method opens a new session and Inserts the model object of the
     * department into the database.
     * </p>
     * 
     * @param department
     *            model object that stores the department data associated with
     *            model class.
     * @return true Gives the success status of the insertion process.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean insertDepartment(Department department) throws DataException {
        try {
            Session session = getSession();
            session.save(department);
            return true;
        } catch (HibernateException exception) {
            exception.printStackTrace();
            FileUtil.errorLogger("Exception in insertDepartment() : " + exception.getMessage());
            throw new DataException("Error while adding Department ID : " + department.getDepartmentId());
        }
    }

    /**
     * <p>
     * This method opens a new session and modifies the model object of the
     * department in the database.
     * </p>
     * 
     * @param department
     *            model object that stores the department data associated with
     *            model class.
     * @return true Gives the success status of the updation process.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean modifyDepartment(Department department) throws DataException {
        try {
            Session session = getSession();
            session.update(department);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in modifyDepartment() : " + exception.getMessage());
            throw new DataException("Error while updating Department ID : " + department.getDepartmentId());
        }
    }

    /**
     * <p>
     * This method opens a new session and Deletes the department from the
     * records.
     * </p>
     * 
     * @param department
     *            model object that stores the department data associated with
     *            model class.
     * @return true Gives the success status of the deletion process.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean removeDepartment(Department department) throws DataException {
        try {
            Session session = getSession();
            session.delete(department);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in removeDepartment() : " + exception.getMessage());
            throw new DataException("Error while deleting Department ID : " + department.getDepartmentId());
        }
    }

    /**
     * <p>
     * This method searches the department from the records using department ID
     * and returns the data as a model object to display.
     * </p>
     * 
     * @param departementId
     *            contains the ID of the department.
     * @return object gives the appropriate department detail for the
     *         corresponding department ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public Department findDepartment(int departmentId) throws DataException {
        try {
            Session session = getSession();
            return (Department) session.get(Department.class, departmentId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findDepartment() : " + exception.getMessage());
            throw new DataException("Error while searching Department ID : " + departmentId);
        }
    }

    /**
     * <p>
     * This method retrieves the department data from the records and returns
     * the list of data.
     * </p>
     * 
     * @return list Gives the list of department details stored in the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Department> retrieveDepartments() throws DataException {
        try {
            Session session = getSession();
            return session.createCriteria(Department.class).list();
        } catch (HibernateException exception) {
            exception.printStackTrace();
            FileUtil.errorLogger("Exception in retrieveDepartments() : " + exception.getMessage());
            throw new DataException("Error while displaying all Departments");
        }
    }
}
