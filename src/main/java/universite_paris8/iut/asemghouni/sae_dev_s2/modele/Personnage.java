package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


import java.util.ArrayList;
import java.util.List;

public class Personnage {

    private String nom;
    private IntegerProperty pointVie;
    private int PointAttaque;
    private int PointDefense;
    private Arme arme;
    private List<Item> itemPossederParPerso;
    private IntegerProperty x;
    private IntegerProperty y;
    private int vitesse;
    private int largeur;
    private int hauteur;

    public static int compteur = 0;
    private String id;
    private Environnement envi;

    public Personnage(String nom, int PointVie, int PointAttaque, int PointDefense, Arme arme, Environnement envi) {
        this.nom = nom;
        this.pointVie = new SimpleIntegerProperty(PointVie);
        this.PointAttaque = PointAttaque;
        this.PointDefense = PointDefense;
        this.arme = arme;
        this.itemPossederParPerso = new ArrayList<>();
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

    public int getPointDefense() {
        return this.PointDefense;
    }

    public int getPointAttaque() {
        return this.PointAttaque;
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

    public void ramasserItem() {
        System.out.println("Dans ramasserItem : Liste des items dans l'environnement " + envi.getListeItemEnvi());
        for (Item item : envi.getListeItemEnvi()) {
            if (item.getPersonnage().estRamasable(item)) {
                System.out.println("Item ramassé : " + item.getNom());
                this.getEnvi().getListeItemEnvi().remove(item);
                this.getItems().add(item);
                System.out.println("Item ramassé : " + item.getNom());
            }
        }
    }

    public List<Item> getItems() {
        return itemPossederParPerso;
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

//        return "Personnage{" +
//                "nom='" + nom + '\'' +
//                ", pointVie=" + pointVie +
//                ", pointAttaque=" + pointAttaque +
//                ", pointDefense=" + pointDefense +
//                ", arme=" + arme +
//                ", x=" + x.get() +
//                ", y=" + y.get() +
//                ", vitesse=" + vitesse +
//                ", id=" + id +
//                ", envi=" + envi +
//                ", largeur=" + largeur +
//                ", hauteur=" + hauteur +
//                '}';
//    }

    }



