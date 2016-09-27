package com.ideas2it.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ideas2it.util.FileUtil;
import com.ideas2it.dao.TeamDao;
import com.ideas2it.exception.DataException;
import com.ideas2it.model.Project;
import com.ideas2it.model.Team;

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
@Repository("teamDao")
@Transactional
public class TeamDaoHibernate extends GenericDaoHibernate<Team, Long> implements TeamDao {

    public TeamDaoHibernate() {
        super(Team.class);
    }

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
        try {
            Session session = getSession();
            session.save(team);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in insertTeam() : " + exception.getMessage());
            throw new DataException("Error while adding Team ID : " + team.getTeamId());
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
        try {
            Session session = getSession();
            session.update(team);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in modifyTeam() : " + exception.getMessage());
            throw new DataException("Error while updating Team ID : " + team.getTeamId());
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
        try {
            Session session = getSession();
            session.delete(team);
            return true;
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in removeUser() : " + exception.getMessage());
            throw new DataException("Error while deleting Team ID : " + team.getTeamId());
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
        try {
            Session session = getSession();
            return (Team) session.get(Team.class, teamId);
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in findTeam() : " + exception.getMessage());
            throw new DataException("Error while searching Team ID : " + teamId);
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
        try {
            Session session = getSession();
            return session.createCriteria(Team.class).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveTeams() : " + exception.getMessage());
            throw new DataException("Error while displaying all Teams");
        }
    }

    /**
     * <p>
     * This method retrieves the team data from the records and returns the list
     * of data for given project.
     * </p>
     * 
     * @param projectId
     *            contains identity of the project
     * @throws DataException
     *             throws error message if problem arises with retrieving list
     *             of data from the database.
     * @return Team.List return the list of team which is stored under the given
     *         project
     */
    public List<Team> retrieveTeamByProject(int projectId) throws DataException {
        try {
            Session session = getSession();
            return session.createQuery("From Team WHERE project_id=" + projectId).list();
        } catch (HibernateException exception) {
            FileUtil.errorLogger("Exception in retrieveTeamByProject() : " + exception.getMessage());
            throw new DataException("Error while displaying all Team");
        }
    }
}
