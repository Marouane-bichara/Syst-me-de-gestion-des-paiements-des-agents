package model;

public abstract class Personne {
    public String nom;
    public String prenom;
    public String email;
    public String motDePasse;

    public Personne(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }
}
