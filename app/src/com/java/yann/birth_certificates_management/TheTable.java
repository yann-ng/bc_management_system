package com.java.yann.birth_certificates_management;


import java.util.Date;

public class TheTable
{
    int certificateID;
    String fullName;
    String gender;
    String place_of_birth;
    Date date_of_birth;
    String fatherName;
    String motherName;

    /**
     * Constructor of the class
     *
     * @param certificateID     the id of the certificate in database
     * @param fullName          the name of the Birth Certificate
     * @param gender            the gender of the Birth Certificate
     * @param place_of_birth    the place of birth of the Birth Certificate
     * @param date_of_birth     the date of birth of the Birth Certificate
     * @param fatherName        the father name of the Birth Certificate
     * @param motherName        the mother name info of the Birth Certificate
     */

    public TheTable(int certificateID, String fullName, String gender, String place_of_birth, Date date_of_birth, String fatherName, String motherName)
    {
        this.certificateID = certificateID;
        this.fullName = fullName;
        this.gender = gender;
        this.place_of_birth = place_of_birth;
        this.date_of_birth = date_of_birth;
        this.fatherName = fatherName;
        this.motherName = motherName;

    }
    /**
     * returns the ID of the Birth Certificate
     *
     * @return The ID: {@link String} of the Birth Certificate
     */
    public int getCertificateID() {
        return certificateID;
    }
    /**
     * changes the ID of the Birth Certificate
     *
     * @param certificateID The ID: {@link String} to set to the Birth Certificate
     */
    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }

    /**
     * returns the name of the Birth Certificate
     *
     * @return The name: {@link String} of the Birth Certificate
     */
    public String getFullName() { return fullName; }

    /**
     * changes the name of the Birth Certificate
     *
     * @param fullName The name: {@link String} to set to the Birth Certificate
     */

    public void setFullName(String fullName) { this.fullName = fullName; }

    /**
     * returns the gender of the Birth Certificate
     *
     * @return the gender: {@link String} of the Birth Certificate
     */

    public String getGender() { return gender; }

    /**
     * changes the gender of the Birth Certificate
     *
     * @param gender The gender: {@link String} to set to the Birth Certificate
     */

    public void setGender(String gender) { this.gender = gender; }

    /**
     * returns the Place of Birth of the Birth Certificate
     *
     * @return the Place of Birth: {@link String} of the Birth Certificate
     */
    public String getPlace_of_birth() {return place_of_birth;}

    /**
     * changes the place of birth of the Birth Certificate
     *
     * @param place_of_birth the Place Of Birth: {@link String} to set to the Birth Certificate
     */
    public void setPlace_of_birth(String place_of_birth) {this.place_of_birth = place_of_birth;}

    /**
     * returns the Date Of Birth of the Birth Certificate
     *
     * @return The Date of birth: {@link String} of the Birth Certificate
     */
    public Date getDate_of_birth() { return date_of_birth; }

    /**
     * changes the Date of birth of the Birth Certificate
     *
     * @param date_of_birth The Date of Birth: {@link String} to set to the Birth Certificate
     */
    public void setDate_of_birth(Date date_of_birth) { this.date_of_birth= date_of_birth; }

    /**
     * returns the Option of the Birth Certificate
     *
     * @return the fatherName: {@link String} of the Birth Certificate
     */
    public String getFatherName() {return fatherName;}

    /**
     * changes the option of the Birth Certificate
     *
     * @param fatherName The option: {@link String} to set to the Birth Certificate
     */
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    /**
     * returns the Option of the Birth Certificate
     *
     * @return the fatherName: {@link String} of the Birth Certificate
     */
    public String getMotherName() {return fatherName;}

    /**
     * changes the option of the Birth Certificate
     *
     * @param motherName The option: {@link String} to set to the Birth Certificate
     */
    public void setMotherName(String motherName) { this.motherName = motherName; }
}

