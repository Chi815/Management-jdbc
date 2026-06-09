package model;

import java.sql.Timestamp;

public class Teacher {

    private int id;
    private String fullName;
    private String email;
    private String subject;
    private String phoneNumber;
    private String employment_type;
    private Timestamp createdAt;

    public Teacher() {
    }

    public Teacher(
            String fullName,
            String email,
            String subject,
            String phoneNumber,
            String employment_type
    ) {
        this.fullName = fullName;
        this.email = email;
        this.subject = subject;
        this.phoneNumber = phoneNumber;
        this.employment_type = employment_type;
    }

    public Teacher(
            int id,
            String fullName,
            String email,
            String subject,
            String phoneNumber,
            String employment_type
    ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.subject = subject;
        this.phoneNumber = phoneNumber;
        this.employment_type = employment_type;
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


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getemployment_type() {
        return employment_type;
    }

    public void setemployment_type(String employment_type) {
        this.employment_type = employment_type;
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
                ", subject='" + subject + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", employment_type='" + employment_type + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}