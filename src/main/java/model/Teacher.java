package model;

import java.sql.Timestamp;

public class Teacher {

    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String employmentType;
    private Timestamp createdAt;

    public Teacher() {
    }

    public Teacher(
            String fullName,
            String email,
            String phoneNumber,
            String employmentType
    ) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.employmentType = employmentType;
    }

    public Teacher(
            int id,
            String fullName,
            String email,
            String phoneNumber,
            String employmentType
    ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.employmentType = employmentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}