package com.TMS.tailoring_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate ID
    private Long id;

    @NotNull(message = "Name is required")
    @Column(name = "Customer_Name")
    private String customerName;

    @NotNull(message = "Phone Number is required")
    @Column(name = "Customer_Phone")
    private String phoneNumber;

    @NotNull(message = "E-mail is required")
    @Email(message = "Please provide a valid email address")
    @Column(name = "Customer_Email", unique = true)
    private String email;

    @NotNull(message = "Please enter your address")
    @Column(name = "Customer_Address")
    private String address;

    @NotNull
    @Column(name = "Appointment_Type")
    private String appointmentType;

    @NotNull(message = "Appointment Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "Appointment_Date")
    private Date appointmentDate;

    @Column(name = "Extra_Details")
    private String details;

   

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    
}
