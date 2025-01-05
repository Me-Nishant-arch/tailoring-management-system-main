package com.TMS.tailoring_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Measurements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique ID for each set of measurements
    
    @Column(name="Shoulder_Size",nullable = true)
    private Double shoulder;

    @Column(name="Sleeve_Size",nullable = true)
    private Double sleeve;

    @Column(name="Chest_Size",nullable = true)
    private Double chest;

    @Column(name="Waist_Size",nullable = true)
    private Double waist;

    @Column(name="Hips_Size",nullable = true)
    private Double hips;

    @Column(name="FrontChest_Size",nullable = true)
    private Double frontChest;

    @Column(name="BackChest_Size",nullable = true)
    private Double backChest;

    @Column(name="Jacket_Size",nullable = true)
    private Double jacket;

    @Column(name="PantsWaist_Size",nullable = true)
    private Double pantsWaist;

    @Column(name="LowHip_Size",nullable = true)
    private Double lowHip;

    @Column(name="Thigh_Size",nullable = true)
    private Double thigh;

    @Column(name="Crotch_Size",nullable = true)
    private Double crotch;
    
    @Column(name="PantLength_Size",nullable = true)
    private Double pantLength;

    @Column(name="Bicep_Size",nullable = true)
    private Double bicep;

    @Column(name="Neck_Size",nullable = true)
    private Double neck;

    @Column(name="Ciffs_Size",nullable = true)
    private Double cuffs;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getShoulder() {
        return shoulder;
    }

    public void setShoulder(Double shoulder) {
        this.shoulder = shoulder;
    }

    public Double getSleeve() {
        return sleeve;
    }

    public void setSleeve(Double sleeve) {
        this.sleeve = sleeve;
    }

    public Double getChest() {
        return chest;
    }

    public void setChest(Double chest) {
        this.chest = chest;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getHips() {
        return hips;
    }

    public void setHips(Double hips) {
        this.hips = hips;
    }

    public Double getFrontChest() {
        return frontChest;
    }

    public void setFrontChest(Double frontChest) {
        this.frontChest = frontChest;
    }

    public Double getBackChest() {
        return backChest;
    }

    public void setBackChest(Double backChest) {
        this.backChest = backChest;
    }

    public Double getJacket() {
        return jacket;
    }

    public void setJacket(Double jacket) {
        this.jacket = jacket;
    }

    public Double getPantsWaist() {
        return pantsWaist;
    }

    public void setPantsWaist(Double pantsWaist) {
        this.pantsWaist = pantsWaist;
    }

    public Double getLowHip() {
        return lowHip;
    }

    public void setLowHip(Double lowHip) {
        this.lowHip = lowHip;
    }

    public Double getThigh() {
        return thigh;
    }

    public void setThigh(Double thigh) {
        this.thigh = thigh;
    }

    public Double getCrotch() {
        return crotch;
    }

    public void setCrotch(Double crotch) {
        this.crotch = crotch;
    }

    public Double getPantLength() {
        return pantLength;
    }

    public void setPantLength(Double pantLength) {
        this.pantLength = pantLength;
    }

    public Double getBicep() {
        return bicep;
    }

    public void setBicep(Double bicep) {
        this.bicep = bicep;
    }

    public Double getNeck() {
        return neck;
    }

    public void setNeck(Double neck) {
        this.neck = neck;
    }

    public Double getCuffs() {
        return cuffs;
    }

    public void setCuffs(Double cuffs) {
        this.cuffs = cuffs;
    }
}
