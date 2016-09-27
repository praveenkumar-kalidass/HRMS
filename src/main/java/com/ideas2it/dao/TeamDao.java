package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Team;

public interface TeamDao extends GenericDao<Team, Long> {

    /**
     * Add new team
     *
     * @return True or False
     */
    boolean insertTeam(Team team) throws DataException;

    /**
     * Update existing team
     *
     * @return True or False
     */
    boolean modifyTeam(Team team) throws DataException;

    /**
     * Delete team
     *
     * @return True or False
     */
    boolean removeTeam(Team team) throws DataException;

    /**
     * Search given team
     *
     * @return Team
     */
    Team findTeam(int teamId) throws DataException;

    /**
     * Retrieve All teams
     *
     * @return list
     */
    List<Team> retrieveTeams() throws DataException;

    /**
     * Retrieve All team for given Project
     *
     * @return list
     */
    List<Team> retrieveTeamByProject(int projectId) throws DataException;
}
