package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Employee;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and
 * performs operation on manipulation of records associated with Employee.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-02
 */

public class EmployeeDao {
	private HibernateConnection hibernateConnection = HibernateConnection.createObject();
	SessionFactory factory = hibernateConnection.establishConnection();

	/**
	 * <p>
	 * This method opens a new session and Inserts the model object of the
	 * employee into the database.
	 * </p>
	 * 
	 * @param employee
	 *            model object that stores the employee data associated with
	 *            model.
	 * @return true Gives the success status of the insertion process.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean insertEmployee(Employee employee) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in insertEmployee() : " + exception.getMessage());
			throw new DataException("Error while adding Employee ID : " + employee.getEmployeeId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method opens a new session and modify the model object of the
	 * employee from the database.
	 * </p>
	 * 
	 * @param employee
	 *            model object that stores the employee data associated with
	 *            model class.
	 * @return true Gives the success status of the updation process.
	 * @throws DataException
	 *             throws error message if problem arises with updating the data
	 *             in the database.
	 */
	public boolean modifyEmployee(Employee employee) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
			System.out.println("Dao out");
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in insertEmployee() : " + exception.getMessage());
			throw new DataException("Error while adding Employee ID : " + employee.getEmployeeId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method opens a new session and deletes the employee from the
	 * records.
	 * </p>
	 * 
	 * @param employeeId
	 *            contains the ID of the employee.
	 * @return true Gives the success status of the deletion process.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean removeEmployee(Employee employee) throws DataException {
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
			return true;
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in removeEmployee() : " + exception.getMessage());
			throw new DataException("Error while deleting Employee ID : " + employee.getEmployeeId());
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method searches the employee from the records using employee ID and
	 * returns the data as a model object to display.
	 * </p>
	 * 
	 * @param departementId
	 *            contains the ID of the employee.
	 * @return object gives the appropriate employee detail for the
	 *         corresponding employee ID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Employee findEmployee(int employeeId) throws DataException {
		Session session = factory.openSession();
		try {
			return (Employee) session.get(Employee.class, employeeId);
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in findEmployee() : " + exception.getMessage());
			throw new DataException("Error while searching Employee ID : " + employeeId);
		} finally {
			session.close();
		}
	}

	/**
	 * <p>
	 * This method retrieves the employee data from the records and returns the
	 * list of data.
	 * </p>
	 * 
	 * @return list Gives the list of employee details stored in the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Employee> getEmployees() throws DataException {
		Session session = factory.openSession();
		try {
			return session.createCriteria(Employee.class).list();
		} catch (HibernateException exception) {
			FileUtil.ErrorLogger("Exception in retrieveEmployees() : " + exception.getMessage());
			throw new DataException("Error while displaying all Employees");
		} finally {
			session.close();
		}
	}
}
