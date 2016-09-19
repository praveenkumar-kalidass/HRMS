package com.i2i.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * <p>
 * Model class which stores the details associated with the Release of the
 * project. Many to One mapping is established for project model class.
 * </p>
 * 
 * @author Praveenkumar
 * 
 * @created 2016-09-09
 */
@Entity
@Table(name = "projectrelease")
public class ProjectRelease {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int releaseId;

    @Column(name = "date")
    private String releaseDate;

    @Column(name = "description")
    private String description;

    @Column(name = "project_version")
    private String projectVersion;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "project_id", nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Project project;

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
