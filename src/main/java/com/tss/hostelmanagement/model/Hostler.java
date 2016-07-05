/*
 * Created on 4 May 2016 ( Time 08:38:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.tss.hostelmanagement.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Java bean for 'Hostler' entity
 * 
 * @author Telosys Tools
 *
 */
public class Hostler implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    // DB : hostlerId BIGINT 
    private Long hostlerId;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    // DB : address VARCHAR 
    private String address;

    // DB : age VARCHAR 
    private int age;

    // DB : amount DECIMAL 
    private BigDecimal amount;

    // DB : dateOfJoining VARCHAR 
    private Date dateOfJoining;

    // DB : deleted INT 
    private Integer deleted;

    // DB : firstName VARCHAR 
    private String firstName;

    // DB : lastName VARCHAR 
    private String lastName;

    // DB : mobileNumber VARCHAR 
    private String mobileNumber;

    // DB : name VARCHAR 
    private String name;

    // DB : qualification VARCHAR 
    private String qualification;

    // DB : roomId BIGINT 
    private Long roomId;

    // DB : sex VARCHAR 
    private String sex;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setHostlerId( Long hostlerId ) {
        this.hostlerId = hostlerId ;
    }

    public Long getHostlerId() {
        return this.hostlerId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setAddress( String address ) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    public void setAge( int age ) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setDateOfJoining( Date dateOfJoining ) {
        this.dateOfJoining = dateOfJoining;
    }
    public Date getDateOfJoining() {
        return this.dateOfJoining;
    }

    public void setDeleted( Integer deleted ) {
        this.deleted = deleted;
    }
    public Integer getDeleted() {
        return this.deleted;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setMobileNumber( String mobileNumber ) {
        this.mobileNumber = mobileNumber;
    }
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setQualification( String qualification ) {
        this.qualification = qualification;
    }
    public String getQualification() {
        return this.qualification;
    }

    public void setRoomid( Long roomId ) {
        this.roomId = roomId;
    }
    public Long getRoomId() {
        return this.roomId;
    }

    public void setSex( String sex ) {
        this.sex = sex;
    }
    public String getSex() {
        return this.sex;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(hostlerId);
        sb.append("|");
        sb.append(address);
        sb.append("|");
        sb.append(age);
        sb.append("|");
        sb.append(amount);
        sb.append("|");
        sb.append("|");
        sb.append(deleted);
        sb.append("|");
        sb.append(firstName);
        sb.append("|");
        sb.append(lastName);
        sb.append("|");
        sb.append(mobileNumber);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(qualification);
        sb.append("|");
        sb.append(roomId);
        sb.append("|");
        sb.append(sex);
        return sb.toString(); 
    } 


}