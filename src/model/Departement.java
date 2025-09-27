package model;

import java.util.ArrayList;

public class Departement {
    private int id;
    private String name;
    private ArrayList<Agent> agents;

    public Departement(int id, String name,  ArrayList<Agent> agents) {
        this.id = id;
        this.name = name;
        this.agents = agents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public void setAgents(ArrayList<Agent> agents) {
        this.agents = agents;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", agents=" + agents +
                '}';
    }
}
