package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;

public class Item {
    private Personnage personnage;
    private String nom;
    private IntegerProperty x;
    private IntegerProperty y;

    protected Environnement envi;
    private int largeur;
    private int hauteur;
    public static int compteur = 0;
    private String id;

    public Item(String nom, Environnement envi) {
        this.nom = nom;
        this.x = new SimpleIntegerProperty();
        this.y = new SimpleIntegerProperty();
        this.id = "#" + compteur;
        this.largeur = 10;
        this.hauteur = 10;
        compteur++;
        this.envi = envi;
        faireApparaitreItemAleatoirement();
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public String getNom() {
        return nom;
    }

    public int getX() {
        return x.get();
    }

    public IntegerProperty getXProperty() {
        return x;
    }

    public int getY() {
        return y.get();
    }

    public IntegerProperty getYProperty() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public String getId() {
        return id;
    }

    public Environnement getEnvi() {
        return envi;
    }

    public void faireApparaitreItemAleatoirement() {

        int x, y;
        boolean positionValide;

        int largeurMap = this.getEnvi().getMap().getLargeur();
        int hauteurMap = this.getEnvi().getMap().getHauteur();
        int tailleTuile = 38;

        do {
            x = (int) (Math.random() * largeurMap) * tailleTuile;
            y = (int) (Math.random() * hauteurMap) * tailleTuile;

            positionValide = !this.getEnvi().getMap().estMur(x, y) && !this.getEnvi().getMap().estLimite(x, y);

        } while (!positionValide);

        this.setX(x);
        this.setY(y);
    }

}