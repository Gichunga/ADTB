package com.gwazasoftwares.ADTB.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HealthFacility {

    @Id
    private String  name;
    private String  abbreviation;
    private String  description;
    private String  location_desc;
    private int     number_of_beds;
    private int     number_of_cots;
    private boolean    open_whole_day;
    private boolean open_whole_week;
    private String  facility_type;
    private String  operation_status;
    private String       ward;
    private String       owner;
    private String       officer_in_charge;
    private String       physical_address;
    private String       parent;


    public HealthFacility() {
    }

    public HealthFacility(String name, String abbreviation, String description, String location_desc, int number_of_beds, int number_of_cots, boolean open_whole_day, boolean open_whole_week, String facility_type, String operation_status, String ward, String owner, String officer_in_charge, String physical_address, String parent) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
        this.location_desc = location_desc;
        this.number_of_beds = number_of_beds;
        this.number_of_cots = number_of_cots;
        this.open_whole_day = open_whole_day;
        this.open_whole_week = open_whole_week;
        this.facility_type = facility_type;
        this.operation_status = operation_status;
        this.ward = ward;
        this.owner = owner;
        this.officer_in_charge = officer_in_charge;
        this.physical_address = physical_address;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation_desc() {
        return location_desc;
    }

    public void setLocation_desc(String location_desc) {
        this.location_desc = location_desc;
    }

    public int getNumber_of_beds() {
        return number_of_beds;
    }

    public void setNumber_of_beds(int number_of_beds) {
        this.number_of_beds = number_of_beds;
    }

    public int getNumber_of_cots() {
        return number_of_cots;
    }

    public void setNumber_of_cots(int number_of_cots) {
        this.number_of_cots = number_of_cots;
    }

    public boolean getOpen_whole_day() {
        return open_whole_day;
    }

    public void setOpen_whole_day(boolean open_whole_day) {
        this.open_whole_day = open_whole_day;
    }

    public boolean isOpen_whole_week() {
        return open_whole_week;
    }

    public void setOpen_whole_week(boolean open_whole_week) {
        this.open_whole_week = open_whole_week;
    }

    public String getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(String facility_type) {
        this.facility_type = facility_type;
    }

    public String getOperation_status() {
        return operation_status;
    }

    public void setOperation_status(String operation_status) {
        this.operation_status = operation_status;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOfficer_in_charge() {
        return officer_in_charge;
    }

    public void setOfficer_in_charge(String officer_in_charge) {
        this.officer_in_charge = officer_in_charge;
    }

    public String getPhysical_address() {
        return physical_address;
    }

    public void setPhysical_address(String physical_address) {
        this.physical_address = physical_address;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
