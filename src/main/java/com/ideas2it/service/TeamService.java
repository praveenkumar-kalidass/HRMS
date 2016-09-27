package com.ideas2it.service;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Team;

public interface TeamService {

    /**
     * Add new team
     *
     * @return True or Fales
     */
    public boolean addTeam(Team team) throws DataException;

    /**
     * Update existing team
     *
     * @return True or Fales
     */
    public boolean updateTeam(Team team) throws DataException;

    /**
     * Delete team
     *
     * @return True or Fales
     */
    public boolean deleteTeam(int teamId) throws DataException;

    /**
     * Search given team
     *
     * @return Team
     */
    public Team searchTeam(int teamId) throws DataException;

    /**
     * Retrive All team
     *
     * @return list
     */
    public List<Team> retriveTeams() throws DataException;

    /**
     * Retrive All team for given Project
     *
     * @return list
     */
    public List<Team> getTeamByProject(int projectId) throws DataException;
}
