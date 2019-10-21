package ru.job4j.hierarchy;

public class Engineer extends Profession {
    private String level;
    private int workExperience;
    private boolean freelancer;

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public int getWorkExperience() {
        return workExperience;
    }
    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public boolean isFreelancer() {
        return freelancer;
    }
    public void setFreelancer(boolean freelancer) {
        this.freelancer = freelancer;
    }

    public Profit priceCalc = new Profit();
    public Deadline orderDuration = new Deadline();
    public Calculation totalOffer = new Calculation();
}

