package org.example.model.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    protected int employeeId;

    @Column(name = "firstName", nullable = false)
    protected String firstName;

    @Column(name = "lastName", nullable = false)
    protected String lastName;

    @Column(name = "gender", nullable = false)
    protected int gender;

    @Column(name = "dateOfBirth", nullable = false)
    protected LocalDate dateOfBirth;

    @Column(name = "phone", unique = true, nullable = false)
    protected String phone;

    @Column(name = "address", nullable = false)
    protected String address;

    @Column(name = "departmentName", nullable = false)
    protected String departmentName;

    @Column(name = "remark")
    protected String remark;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Account account;
}
