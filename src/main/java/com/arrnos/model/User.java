package com.arrnos.model;



public class User {

    private String userName;
    private int age;
    private String job;
    private String marital;
    private String education;
    private int balance;
    private int day;
    private String month;
    private int duration;
    private int campaign;
    private int pdays;
    private int previous;
    private String poutcome;

    public User() {

    }


    public User(String userName, int age, String job, String marital, String education, int balance, int day, String month, int duration, int campaign, int pdays, int previous, String poutcome) {
        this.userName = userName;
        this.age = age;
        this.job = job;
        this.marital = marital;
        this.education = education;
        this.balance = balance;
        this.day = day;
        this.month = month;
        this.duration = duration;
        this.campaign = campaign;
        this.pdays = pdays;
        this.previous = previous;
        this.poutcome = poutcome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCampaign() {
        return campaign;
    }

    public void setCampaign(int campaign) {
        this.campaign = campaign;
    }

    public int getPdays() {
        return pdays;
    }

    public void setPdays(int pdays) {
        this.pdays = pdays;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public String getPoutcome() {
        return poutcome;
    }

    public void setPoutcome(String poutcome) {
        this.poutcome = poutcome;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", marital='" + marital + '\'' +
                ", education='" + education + '\'' +
                ", balance=" + balance +
                ", day=" + day +
                ", month='" + month + '\'' +
                ", duration=" + duration +
                ", campaign=" + campaign +
                ", pdays=" + pdays +
                ", previous=" + previous +
                ", poutcome='" + poutcome + '\'' +
                '}';
    }
}
