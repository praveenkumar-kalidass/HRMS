package com.ideas2it.service;

import com.ideas2it.exception.DataException;
import com.ideas2it.model.Role;

import java.util.List;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface RoleManager extends GenericManager<Role, Long> {
	/**
	 * {@inheritDoc}
	 * 
	 * @throws DataException
	 */
	List getRoles() throws DataException;

	/**
	 * {@inheritDoc}
	 */
	Role getRole(String rolename);

	/**
	 * {@inheritDoc}
	 */
	Role saveRole(Role role);

	/**
	 * {@inheritDoc}
	 */
	void removeRole(String rolename);
}
