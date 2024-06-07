package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;

import java.util.ArrayList;
import java.util.List;

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
        faireApparaitreItemAléatoirement();
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

    private void faireApparaitreItemAléatoirement() {

        int x,y;

        do {
            x = (int) (Math.random() * this.getEnvi().getMap().getHauteur() * 38);
            y = (int) (Math.random() * this.getEnvi().getMap().getLargeur() * 38);

        } while (envi.getMap().getMapJeu()[indiceObstacle(x,y)] == 5 && !envi.getMap().estLimite(x,y));

        this.setX(x);
        this.setY(y);

    }

    private int indiceObstacle(int newX, int newY) {

        int ligne, colonne;

        colonne = newX / 38;
        ligne = newY / 38;

        return ligne * 15 + colonne;
    }

}