package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Item {

private String nom;

private IntegerProperty x;
private IntegerProperty y;
private int largeur;
private int hauteur;

//    public static int compteur = 0;
private int id;
private Environnement envi;

    public Item(String nom, Environnement envi) {
        int random = (int) ((200 * Math.random()));
        this.nom = nom;
        this.x = new SimpleIntegerProperty(random);
        this.y = new SimpleIntegerProperty(random);
    //        this.dx = dx;
    //        this.dy = dy;
        this.id = 0;
        this.largeur = 10;
        this.hauteur = 10;
    //        compteur++;
        this.envi = new Environnement();
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

    public int getId() {
        return id;
    }
}