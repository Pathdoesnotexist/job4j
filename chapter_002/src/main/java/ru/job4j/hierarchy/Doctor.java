package ru.job4j.hierarchy;

public class Doctor extends Profession {
    private String hospitalName;
    private int yearsOfPractice;
    private boolean privatePractice;

    public String getHospitalName() {
        return hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getYearsOfPractice() {
        return yearsOfPractice;
    }
    public void setYearsOfPractice(int yearsOfPractice) {
        this.yearsOfPractice = yearsOfPractice;
    }

    public boolean isPrivatePractice() {
        return privatePractice;
    }
    public void setPrivatePractice(boolean privatePractice) {
        this.privatePractice = privatePractice;
    }

    public Duty onDuty = new Duty();
    public Inspection initInspection = new Inspection();
    public Diagnosis diagnosis = new Diagnosis();
}
