package com.ats.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    @JsonProperty("id")
    private Long id;

    @Column(name = "FIRST_NAME")
    @JsonProperty("firstName")
    private String firstName;
    @Column(name = "LAST_NAME")
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "USERNAME")
    @JsonProperty("username")
    private String username;

    @Column(name = "SALARY")
    @JsonProperty("salary")
    private Double salary;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("creationDate")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime creationDate;

    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("updateDate")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime updateDate;

    @OneToMany
     public  List<Task> tasks = new ArrayList<Task>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }


}
