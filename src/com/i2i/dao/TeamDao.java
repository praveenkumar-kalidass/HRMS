package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;
import com.i2i.model.Team;

/**
 * <p>
 * Dao(Data Access Object) class which establishes session with the database and
 * performs operation on manipulation of records associated with Teams.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-09
 */
public class TeamDao {
    private HibernateConnection hibernateConnection = HibernateConnection.createObject();
    SessionFactory factory = hibernateConnection.establishConnection();

    /**
     * <p>
     * This method opens a new session and Inserts the model object of the team
     * into the database.
     * </p>
     * 
     * @param team
     *            model object that stores the team data associated with model
     *            class.
     * @return true Gives the success status of the insertion process.
     * @throws DataException
     *             throws error message if problem arises with inserting the
     *             data in the database.
     */
    public boolean insertTeam(Team team) throws DataException {
        Session session = factory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(team);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in insertTeam() : " + exception.getMessage());
            throw new DataException("Error while adding Team ID : " + team.getTeamId());
        } finally {
            session.close();
        }
    }

    /**
     * <p>
     * This method opens a new session and modifies the model object of the team
     * in the database.
     * </p>
     * 
     * @param team
     *            model object that stores the team data associated with model
     *            class.
     * @return true Gives the success status of the updation process.
     * @throws DataException
     *             throws error message if problem arises with updating the data
     *             in the database.
     */
    public boolean modifyTeam(Team team) throws DataException {
        Session session = factory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.update(team);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in modifyTeam() : " + exception.getMessage());
            throw new DataException("Error while updating Team ID : " + team.getTeamId());
        } finally {
            session.close();
        }
    }

    /**
     * <p>
     * This method opens a new session and Deletes the team from the records.
     * </p>
     * 
     * @param team
     *            model object that stores the team data associated with model
     *            class.
     * @return true Gives the success status of the deletion process.
     * @throws DataException
     *             throws error message if problem arises with deleting the data
     *             in the database.
     */
    public boolean removeTeam(Team team) throws DataException {
        Session session = factory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(team);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in removeEmployee() : " + exception.getMessage());
            throw new DataException("Error while deleting Team ID : " + team.getTeamId());
        } finally {
            session.close();
        }
    }

    /**
     * <p>
     * This method searches the team from the records using team ID and returns
     * the data as a model object to display.
     * </p>
     * 
     * @param departementId
     *            contains the ID of the team.
     * @return object gives the appropriate team detail for the corresponding
     *         team ID.
     * @throws DataException
     *             throws error message if problem arises with searching the
     *             data in the database.
     */
    public Team findTeam(int teamId) throws DataException {
        Session session = factory.openSession();
        try {
            return (Team) session.get(Team.class, teamId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findTeam() : " + exception.getMessage());
            throw new DataException("Error while searching Team ID : " + teamId);
        } finally {
            session.close();
        }
    }

    /**
     * <p>
     * This method retrieves the team data from the records and returns the list
     * of data.
     * </p>
     * 
     * @return list Gives the list of team details stored in the database.
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     */
    public List<Team> retrieveTeams() throws DataException {
        Session session = factory.openSession();
        try {
            return session.createCriteria(Team.class).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveTeams() : " + exception.getMessage());
            throw new DataException("Error while displaying all Teams");
        } finally {
            session.close();
        }
    }
    
    
    /**
     * <p>
     * This method retrieves the team data from the records and returns
     * the list of data for given project.
     * </p>
     * 
     * @param projectId
     *            contains identity of the project
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     * @return Team.List return the list of team which is stored
     *         under the given project
     */
    public List<Team> retrieveTeamByProject(int projectId) throws DataException {
        Session session = factory.openSession();
        try {
            return session.createQuery("From Team WHERE project_id=" + projectId).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveTeamByProject() : " + exception.getMessage());
            throw new DataException("Error while displaying all Team");
        } finally {
            session.close();
        }
    }
}
