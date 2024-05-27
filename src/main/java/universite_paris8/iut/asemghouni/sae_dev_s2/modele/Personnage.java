package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Personnage {

//    private String nom;
//    private int PointVie;
//    private int PointAttaque;
//    private int PointDefense;
//    private Arme arme;
//    private ArrayList<Item> inventaire;
    private IntegerProperty x;
    private IntegerProperty y;
    private int vitesse;
    private int largeur;
    private int hauteur;

//    public static int compteur = 0;
    private int id;
    private Environnement envi;

    public Personnage() {
//        this.nom = nom;
//        this.PointVie = PointVie;
//        this.PointAttaque = PointAttaque;
//        this.PointDefense = PointDefense;
//        this.arme = arme;
//        this.inventaire = new ArrayList<>();
        this.x = new SimpleIntegerProperty(0);
        this.y = new SimpleIntegerProperty(0);
//        this.dx = dx;
//        this.dy = dy;
        this.id = 0;
        this.vitesse = 5;
        this.largeur = 25;
        this.hauteur = 25;
//        compteur++;
        this.envi = new Environnement();

    }

//    public Personnage(String nom, int PointVie, int x, int y, int dx, int dy, Environnement envi) {                 //Personnage sans arme donc pour la princesse
//        this.nom = nom;
//        this.PointVie = PointVie;
//        this.x = new SimpleIntegerProperty(x);
//        this.y = new SimpleIntegerProperty(y);
//        this.dx = dx;
//        this.dy = dy;
//        this.id = "A"+ compteur;
//        compteur++;
//        this.envi = envi;
//    }

//    public String getNom() {
//        return this.nom;
//    }
//
//    public int getPointVie() {
//        return this.PointVie;
//    }
//
//    public int getPointDefense() {
//        return this.PointDefense;
//    }
//
//    public int getPointAttaque() {
//        return this.PointAttaque;
//    }

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
    public final IntegerProperty getXProperty(){
        return x;
    }
    public final IntegerProperty getYProperty() {
        return y;
    }
    public int getId() {
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


    //    public void ajouterItem(Item item) {
//        this.inventaire.add(item);
//    }

//    public void recevoirDegats(int degats) {
//
//        this.PointVie = this.PointVie - degats;
//
//        if (this.PointVie < 0) {
//            this.PointVie = 0;
//        }
//    }

//    public int attaquer(Personnage victime) {
//
//        int degatInflige;
//
//        if (this.arme != null) {
//            degatInflige = this.getPointAttaque() + this.arme.getPointsAttaqueArme();
//        }
//        else {
//            degatInflige = this.PointAttaque;
//        }
//
//        int degatReelInflige = degatInflige - victime.getPointDefense();
//
//        if (degatReelInflige > 0) {
//
//            victime.recevoirDegats(degatReelInflige);
//        }
//
//        return degatReelInflige;
//
//    }

//    public String toString() {
//        TODO
//    }

}
