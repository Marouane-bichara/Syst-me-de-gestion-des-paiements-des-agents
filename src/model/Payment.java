package model;

import java.util.Date;

public class Payment {
    private int id;
    private TypePyment typePyment;
    private double amount;
    private Date date;
    private String motif;
    private Agent agent;
    private boolean conditionValidee;

    public Payment(Date date, int id, TypePyment typePyment, double amount, String motif, Agent agent, boolean conditionValidee) {
        this.date = date;
        this.id = id;
        this.typePyment = typePyment;
        this.amount = amount;
        this.motif = motif;
        this.agent = agent;
        this.conditionValidee = conditionValidee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypePyment getTypePyment() {
        return typePyment;
    }

    public void setTypePyment(TypePyment typePyment) {
        this.typePyment = typePyment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public boolean isConditionValidee() {
        return conditionValidee;
    }

    public void setConditionValidee(boolean conditionValidee) {
        this.conditionValidee = conditionValidee;
    }
}
