package model;

import java.util.Date;

public class Payment {
    private int id;
    private TypePyment type;
    private double amount;
    private Date datePaiement;
    private String motif;
    private Agent agent;
    private int conditionValidee;

    public Payment(Date datePaiement, int id, TypePyment type, double amount, String motif, Agent agent, int conditionValidee) {
        this.datePaiement = datePaiement;
        this.id = id;
        this.type = type;
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
        return type;
    }

    public void setTypePyment(TypePyment type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return datePaiement;
    }

    public void setDate(Date datePaiement) {
        this.datePaiement = datePaiement;
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


    public int isConditionValidee() {
        return conditionValidee;
    }

    public void setConditionValidee(int conditionValidee) {
        this.conditionValidee = conditionValidee;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", typePyment=" + type +
                ", amount=" + amount +
                ", date=" + datePaiement +
                ", motif='" + motif + '\'' +
                ", agent=" + agent +
                ", conditionValidee=" + conditionValidee +
                '}';
    }
}
