package model;

import java.util.ArrayList;

public class Agent extends Personne{
    private int id;
    private TypeAgent typeAgent;
    private Departement departement;
    private ArrayList<Payment> payments;


    public Agent(String nom, String prenom, String email, String motDePasse, int id, TypeAgent typeAgent, Departement departement, ArrayList<Payment> payments) {
        super(nom, prenom, email, motDePasse);
        this.id = id;
        this.typeAgent = typeAgent;
        this.departement = departement;
        this.payments = payments;
    }
}
