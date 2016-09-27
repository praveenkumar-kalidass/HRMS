package com.ideas2it.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * <p>
 * Model class which stores the details associated with the Team of a project.
 * </p>
 * 
 * @author Praveenkumar
 * 
 * @created 2016-09-09
 */
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private int teamId;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = true, updatable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Project project;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true, updatable = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private User user;

    @Column(name = "role")
    private String teamRole;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(String teamRole) {
        this.teamRole = teamRole;
    }
}
