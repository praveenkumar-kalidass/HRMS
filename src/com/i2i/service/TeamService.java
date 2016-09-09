package com.i2i.service;

import java.util.List;

import com.i2i.dao.TeamDao;
import com.i2i.exception.DataException;
import com.i2i.model.Team;

/**
 * <p>
 * Service class which does validations with the user input of team details.
 * Passes values to the Dao class to carry out manipulations. Throws error
 * messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-09-09
 */
public class TeamService {
	TeamDao teamDao = new TeamDao();

	/**
	 * <p>
	 * This method Passes the values to its dao class to insert into the
	 * database.
	 * </p>
	 * 
	 * @param team
	 *            model object that stores the team data associated with model.
	 * @return boolean gives the status of the insertion into the database.
	 * @throws DataException
	 *             throws error message if problem arises with inserting the
	 *             data in the database.
	 */
	public boolean addTeam(Team team) throws DataException {
		return teamDao.insertTeam(team);
	}

	/**
	 * <p>
	 * This method Passes the values to its dao class to update the existing
	 * team in the database.
	 * </p>
	 * 
	 * @param team
	 *            model object that stores the team data associated with model.
	 * @return boolean gives the status of the update from the database.
	 * @throws DataException
	 *             throws error message if problem arises with updating the data
	 *             in the database.
	 */
	public boolean updateTeam(Team team) throws DataException {
		return teamDao.modifyTeam(team);
	}

	/**
	 * <p>
	 * This method checks the presence of team ID in the database. Passes the
	 * value to its dao class to delete if present.
	 * </p>
	 * 
	 * @param teamId
	 *            contains the ID of the team.
	 * @return boolean gives the status of the deletion from the database.
	 * @throws DataException
	 *             throws error message if problem arises with deleting the data
	 *             in the database.
	 */
	public boolean deleteTeam(int teamId) throws DataException {
		if (teamDao.findTeam(teamId) != null) {
			return teamDao.removeTeam(searchTeam(teamId));
		}
		return false;
	}

	/**
	 * <p>
	 * This method passes the team ID to its dao class to search in the
	 * database. Returns the model object of the team to its controller to
	 * display.
	 * </p>
	 *
	 * @param teamId
	 *            contains the ID of the team.
	 * @return object gives the appropriate team object for the corresponding
	 *         team ID.
	 * @throws DataException
	 *             throws error message if problem arises with searching the
	 *             data in the database.
	 */
	public Team searchTeam(int teamId) throws DataException {
		return teamDao.findTeam(teamId);
	}

	/**
	 * <p>
	 * This method retrieves the Team data from the records and returns the list
	 * of data to display.
	 * </p>
	 * 
	 * @return list Gives the list of team details retrieved from the database.
	 * @throws DataException
	 *             throws error message if problem arises with retrieving list
	 *             of data from the database.
	 */
	public List<Team> displayTeams() throws DataException {
		return teamDao.retrieveTeams();
	}
}