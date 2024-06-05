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
    private List<Item> itemPossederParPerso;
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

    public void recevoirDegats(int degats) {

        int pointVieActuels = this.pointVie.get();

        pointVieActuels = pointVieActuels - degats;

        if (pointVieActuels < 0) {
            pointVieActuels = 0;
        }
    }

    public int attaquer(Personnage victime) {

        int degatInflige;
        int pointVie = victime.getPointVie().get();

        if (this.arme != null) {
            degatInflige = this.arme.getPointsAttaqueArme();
        }
        else {
            degatInflige = 0;
        }

        int degatReelInflige = degatInflige - pointVie;

        if (degatReelInflige > 0) {

            victime.recevoirDegats(degatReelInflige);
        }

        return degatReelInflige;

    }

    public String toString() {

        return "Personnage {" +
                "nom='" + nom + '\'' +
                ", pointVie=" + pointVie +
                ", arme=" + arme +
                ", x=" + x.get() +
                ", y=" + y.get() +
                ", vitesse=" + vitesse +
                ", id=" + id +
                ", envi=" + envi +
                ", largeur=" + largeur +
                ", hauteur=" + hauteur +
                " }";
    }

}



