package com.springlove.simple_management_employee.entity;

import com.springlove.simple_management_employee.enums.EmployeeStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employees")
@SQLDelete(sql =  "UPDATE employees SET emp_deleted = true WHERE emp_id = ?")
@Where(clause = "emp_deleted = false")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "emp_status")
    private EmployeeStatus status;

    @Column(name = "emp_create_at")
    private LocalDateTime createAt;

    @Column(name = "emp_deleted")
    private boolean deleted;

    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
        this.status = EmployeeStatus.ACTIVE;
        this.deleted = false;
    }


    public Employee() {
    }

    public Employee(Integer id, String name, String email, EmployeeStatus status, LocalDateTime createAt, boolean deleted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = EmployeeStatus.ACTIVE;
        this.createAt = createAt;
        this.deleted = false;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
