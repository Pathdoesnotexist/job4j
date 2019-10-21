package ru.job4j.hierarchy;

public class Surgeon extends Doctor {
    private String specialization;

    public Laparoscopy laparoscopy = new Laparoscopy();
    public Laparotomy laparotomy = new Laparotomy();
    public Amputation amputation = new Amputation();
}
