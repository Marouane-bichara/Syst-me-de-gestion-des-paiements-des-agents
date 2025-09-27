package model;

import java.util.Date;

public class Payment {
    private int id;
    private TypePyment typePyment;
    private double amount;
    private Date date;
    private String motif;
    private Agent agent;
    private String typePrime;
    private double salairBase;
    private boolean conditionValidee;

    public Payment(Date date, int id, TypePyment typePyment, double amount, String motif, Agent agent,String typePrime, double salairBase, boolean conditionValidee) {
        this.date = date;
        this.id = id;
        this.typePyment = typePyment;
        this.amount = amount;
        this.motif = motif;
        this.agent = agent;
        this.typePrime = typePrime;
        this.salairBase = salairBase;
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

    public String getTypePrime() {
        return typePrime;
    }

    public void setTypePrime(String typePrime) {
        this.typePrime = typePrime;
    }

    public double getSalairBase() {
        return salairBase;
    }

    public void setSalairBase(double salairBase) {
        this.salairBase = salairBase;
    }

    public boolean isConditionValidee() {
        return conditionValidee;
    }

    public void setConditionValidee(boolean conditionValidee) {
        this.conditionValidee = conditionValidee;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", typePyment=" + typePyment +
                ", amount=" + amount +
                ", date=" + date +
                ", motif='" + motif + '\'' +
                ", agent=" + agent +
                ", typePrime='" + typePrime + '\'' +
                ", salairBase=" + salairBase +
                ", conditionValidee=" + conditionValidee +
                '}';
    }
}
