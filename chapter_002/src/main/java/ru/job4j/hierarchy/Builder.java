package ru.job4j.hierarchy;

public class Builder extends Engineer {
    private String tools;

    public String getTools() {
        return tools;
    }
    public void setTools(String tools) {
        this.tools = tools;
    }

    public Building building = new Building();
    public Fence fence = new Fence();
    public Road road = new Road();
}
