package com.ideas2it.dao.hibernate;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.User;
import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.UserDao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.transaction.Transactional;

import java.util.List;

/**
 * This class interacts with Hibernate session to save/delete and retrieve User
 * objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler</a> Extended to
 *         implement Acegi UserDetailsService interface by David Carter
 *         david@carter.net Modified by <a href="mailto:bwnoll@gmail.com">Bryan
 *         Noll</a> to work with the new BaseDaoHibernate implementation that
 *         uses generics. Modified by jgarcia (updated to hibernate 4)
 */
@Repository("userDao")
@Transactional
public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements UserDao, UserDetailsService {

    /**
     * Constructor that sets the entity to User.class.
     */
    public UserDaoHibernate() {
        super(User.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Query qry = getSession().createQuery("from User u order by upper(u.username)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public User saveUser(User user) {
        if (log.isDebugEnabled()) {
            log.debug("user's id: " + user.getId());
        }
        getSession().saveOrUpdate(user);
        // necessary to throw a DataIntegrityViolation and catch it in
        // UserManager
        getSession().flush();
        return user;
    }

    /**
     * Overridden simply to call the saveUser method. This is happening because
     * saveUser flushes the session and saveObject of BaseDaoHibernate does not.
     *
     * @param user
     *            the user to save
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public User save(User user) {
        return this.saveUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List users = getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).list();
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            return (UserDetails) users.get(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getUserPassword(Long userId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(SessionFactoryUtils.getDataSource(getSessionFactory()));
        Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
        return jdbcTemplate.queryForObject("select password from " + table.name() + " where id=?", String.class,
                userId);
    }

    /**
     * <p>
     * This method opens a new session and Inserts the model object of the user
     * into the database.
     * </p>
     * 
     * @param user
     *            model object that stores the user data associated with model.
     * @return true Gives the success status of the insertion process.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean insertUser(User user) throws DataException {
        try {
            Session session = getSession();
            session.save(user);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in insertUser() : " + exception.getMessage());
            throw new DataException("Error while adding User : " + user.getFirstName());
        }
    }

    /**
     * <p>
     * This method opens a new session and modify the model object of the user
     * from the database.
     * </p>
     * 
     * @param user
     *            model object that stores the user data associated with model
     *            class.
     * @return true Gives the success status of the updation process.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean modifyUser(User user) throws DataException {
        try {
            Session session = getSession();
            session.update(user);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in insertUser() : " + exception.getMessage());
            throw new DataException("Error while adding User ID : " + user.getId());
        }
    }

    /**
     * <p>
     * This method opens a new session and deletes the user from the records.
     * </p>
     * 
     * @param userId
     *            contains the ID of the user.
     * @return true Gives the success status of the deletion process.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean removeUser(User user) throws DataException {
        try {
            Session session = getSession();
            session.delete(user);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in removeUser() : " + exception.getMessage());
            throw new DataException("Error while deleting User ID : " + user.getId());
        }
    }

    /**
     * <p>
     * This method searches the user from the records using user ID and returns
     * the data as a model object to display.
     * </p>
     * 
     * @param departementId
     *            contains the ID of the user.
     * @return object gives the appropriate user detail for the corresponding
     *         user ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public User findUser(long userId) throws DataException {
        try {
            Session session = getSession();
            return (User) session.get(User.class, userId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findUser() : " + exception.getMessage());
            throw new DataException("Error while searching User ID : " + userId);
        }
    }

    /**
     * <p>
     * This method searches the user from the records using user UserName and
     * returns the data as a model object to display.
     * </p>
     * 
     * @param userUserName
     *            contains the User name of the user.
     * @return object gives the appropriate user detail for the corresponding
     *         user username.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public User findUserByUserName(String userUserName) throws DataException {
        try {
            Session session = getSession();
            for (User user : getUsers()) {
                if (user.getUsername().equals(userUserName)) {
                    return user;
                }
            }
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findUser() : " + exception.getMessage());
            throw new DataException("Error while searching User UserName : " + userUserName);
        }
        return null;
    }

    /**
     * <p>
     * This method retrieves the user data from the records and returns the list
     * of data.
     * </p>
     * 
     * @param designationId
     *            contains identity of the designation
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     * @return Designation.List return the list of designation which is stored
     *         under the given department
     */
    public List<User> retrieveUserByDesignation(int designationId) throws DataException {
        try {
            Session session = getSession();
            return session.createQuery(
                    "From User WHERE designation_id=" + designationId + " AND id not in(select user.id from Team)")
                    .list();
        } catch (Exception exception) {
            FileUtil.errorLogger("Exception in retrieveUserByDesignation() : " + exception.getMessage());
            throw new DataException("Error while displaying all User");
        }
    }
}
