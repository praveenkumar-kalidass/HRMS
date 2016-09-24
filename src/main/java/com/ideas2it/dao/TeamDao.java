package com.ideas2it.dao;

import java.util.List;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Team;

public interface TeamDao extends GenericDao<Team, Long> {
	boolean insertTeam(Team team) throws DataException;
	boolean modifyTeam(Team team) throws DataException;
	boolean removeTeam(Team team) throws DataException;
	Team findTeam(int teamId) throws DataException;
	List<Team> retrieveTeams() throws DataException;
	List<Team> retrieveTeamByProject(int projectId) throws DataException ;
}
