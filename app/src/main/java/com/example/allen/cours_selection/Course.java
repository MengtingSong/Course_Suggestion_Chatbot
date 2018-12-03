package com.example.allen.cours_selection;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Course implements Serializable
{

    protected String name;
    protected String code;
    protected String type;
    protected String Year;
    protected String prerequisite;
    protected String credit;
    protected String future;
    protected String description;
    protected String subject_speci;
   // protected String notimportant;



    protected String advise;

    public Course ()
    {
    }

    /*public String getNotimportant() {
        return notimportant;
    }

    public void setNotimportant(String notimportant) {
        this.notimportant = notimportant;
    }*/

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return Year;
    }

    public void setGrade(String grade) {
        Year = grade;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        //int value = Integer.valueOf(credit);
        this.credit = credit;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String replaceString=description.replace("$",",");
        this.description = replaceString;
    }

    public String getSubject_speci() {
        return subject_speci;
    }

    public void setSubject_speci(String subject_speci) {
        this.subject_speci = subject_speci;
    }
}
