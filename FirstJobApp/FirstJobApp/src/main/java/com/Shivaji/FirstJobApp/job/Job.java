package com.Shivaji.FirstJobApp.job;

import jakarta.persistence.*;

@Entity
//@Table(name = "job_table") //to change the name of the table as the name of the table is the class name
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    in the above we are generating the unique id no rather than doing maually as we have performed earlier.
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job() {
    }

    public Job(long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
