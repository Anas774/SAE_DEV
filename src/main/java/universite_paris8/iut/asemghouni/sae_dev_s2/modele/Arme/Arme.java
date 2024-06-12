package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Arme {

    private int PointAttaque;
    private String nom;
    public static int comteur = 0;
    private String id;
    private IntegerProperty x;
    private IntegerProperty y;
    private Environnement envi;

    public Arme(String nom, int PointAttaque) {
        this.nom = nom;
        this.x = new SimpleIntegerProperty();
        this.y = new SimpleIntegerProperty();
        this.id = "#" + comteur;
        this.envi = new Environnement();
        comteur++;
        this.PointAttaque = PointAttaque;
        faireApparaitreArmeAléatoirement();
    }

    public String getNom() {
        return nom;
    }
    public int getPointsAttaqueArme() {
        return this.PointAttaque;
    }

    public String toString() {
        return "\nNom de l'arme : " + this.nom;
    }

    public String getId() {
        return id;
    }

    public int getX() {
        return x.get();
    }

    public void setX(int n) {
        x.set(n);
    }

    public int getY() {
        return y.get();
    }

    public void setY(int n) {
        y.set(n);
    }

    public final IntegerProperty getXProperty() {
        return x;
    }

    public final IntegerProperty getYProperty() {
        return y;
    }

    public Environnement getEnvi() {
        return envi;
    }


    private void faireApparaitreArmeAléatoirement() {

        int x,y;
        boolean positionValide = false;

        do {
            x = (int) (Math.random() * this.getEnvi().getMap().getHauteur() * 38);
            y = (int) (Math.random() * this.getEnvi().getMap().getLargeur() * 38);

            positionValide = !envi.getMap().estMur(x,y) && !envi.getMap().estLimite(x,y);

        } while (!positionValide);

        this.setX(x);
        this.setY(y);

    }
}