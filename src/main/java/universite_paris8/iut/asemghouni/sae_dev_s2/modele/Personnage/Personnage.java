package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;


import java.util.ArrayList;
import java.util.List;

public class Personnage {

    private String nom;
    private IntegerProperty pointVie;
    private Arme arme;
    private IntegerProperty x;
    private IntegerProperty y;
    private int vitesse;
    private int largeur;
    private int hauteur;
    public static int compteur = 0;
    private String id;
    private Environnement envi;

    public Personnage(String nom, int PointVie, Arme arme, Environnement envi) {
        this.nom = nom;
        this.pointVie = new SimpleIntegerProperty(PointVie);
        this.arme = arme;
        this.x = new SimpleIntegerProperty(0);
        this.y = new SimpleIntegerProperty(0);
        this.id = "#" + compteur;
        this.vitesse = 10;
        this.largeur = 25;
        this.hauteur = 25;
        compteur++;
        this.envi = new Environnement();
    }

    public String getNom() {
        return this.nom;
    }

    public IntegerProperty getPointVie() {
        return this.pointVie;
    }

    public void setPointVie(int pointVie) {
        this.pointVie.set(pointVie);
    }

    public IntegerProperty pointVieProperty() {
        return this.pointVie;
    }

    public Arme getArme() {
        return arme;
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

    public String getId() {
        return id;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public Environnement getEnvi() {
        return this.envi;
    }

    public List<int[]> getCoins(int newX, int newY) {
        List<int[]> coins = new ArrayList<>();
        coins.add(new int[]{newX, newY}); // Haut gauche
        coins.add(new int[]{newX + largeur, newY}); // Haut droit
        coins.add(new int[]{newX, newY + hauteur}); // Bas gauche
        coins.add(new int[]{newX + largeur, newY + hauteur}); // Bas droit
        return coins;

    }

    public boolean detectCollision(int newX, int newY) {
        List<int[]> coins = this.getCoins(newX, newY);
        for (int[] coin : coins) {
            if (envi.getMap().estMur(coin[0], coin[1]) || envi.getMap().estLimite(coin[0], coin[1])) {
                return true;
            }
        }
        return false;
    }

    public boolean estRamasable(Item item) {

        if ((this.getY() - 5 <= item.getY() && item.getY() <= this.getY() + 5) && this.getX() - 5 <= item.getX() && item.getX() <= this.getX() + 5) {
            return true;
        }
        return false;
    }

    public void recevoirDegats(int degats) {

        int pointVieActuels = this.pointVie.get();

        pointVieActuels = pointVieActuels - degats;

        if (pointVieActuels < 0) {
            pointVieActuels = 0;
        }
        this.pointVie.set(pointVieActuels);
    }

    public int attaquer(Personnage victime) {

        int degatInflige = 0;
        int pointVie = this.pointVie.get();

        if (peutAttaquerCorpsACorps(victime)) {

            if (this.arme != null) {
                degatInflige = this.arme.getPointsAttaqueArme();
            }

            victime.recevoirDegats(degatInflige);

        }
        return degatInflige;
    }

    public boolean peutAttaquerCorpsACorps(Personnage cible) {

        if (this instanceof SoldatEnnemie) {
            if ((this.getY() - 10 <= cible.getY() && cible.getY() <= this.getY() + 10) &&
                    (this.getX() - 10 <= cible.getX() && cible.getX() <= this.getX() + 10)) {
                return true;
            }
        }
        return false;
    }

    public boolean peutAttaquerDistance(Personnage cible) {

        if (this instanceof SoldatEnnemie) {
            if ((this.getY() - 100 <= cible.getY() && cible.getY() <= this.getY() + 100) &&
                    (this.getX() - 100 <= cible.getX() && cible.getX() <= this.getX() + 100)) {
                return true;
            }
        }
        return false;
    }

    public boolean estVivant() {
        return this.getPointVie().getValue() > 0;
    }

    public String toString() {

        return "Personnage { " +
                "nom ='" + nom + '\'' +
                ", pointVie =" + pointVie +
                ", arme =" + arme +
                ", x =" + x.get() +
                ", y =" + y.get() +
                ", vitesse =" + vitesse +
                ", id =" + id +
                ", envi =" + envi +
                ", largeur =" + largeur +
                ", hauteur =" + hauteur +
                " }";
    }

}



