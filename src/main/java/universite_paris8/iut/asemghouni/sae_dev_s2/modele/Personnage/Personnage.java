package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;


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
        this.vitesse = 8;
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
    public int getVieMax() {
        return 20;
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

    public void recevoirDegats(int degats) {

        int pointVieActuels = this.pointVie.get();

        pointVieActuels = pointVieActuels - degats;

        if (pointVieActuels < 0) {
            pointVieActuels = 0;
        }
        this.pointVie.set(pointVieActuels);
        System.out.println(this.nom + " reçoit " + degats + " dégâts. PV restants : " + this.pointVie.get() + "\n");
    }

    public int attaquer(Personnage victime) {

        int degatInflige = 0;

        if (this instanceof Link) {
            ((Link) this).infligerDegats(victime, degatInflige);
        } else {
            if (VerifpeutAttaquerCorpsACorps(victime)) {
                if (this.arme != null) {
                    degatInflige = this.arme.getPointsAttaqueArme();
                }
                victime.recevoirDegats(degatInflige);
                System.out.println(this.nom + " attaque " + victime.getNom() + " et inflige " + degatInflige + " dégâts." + "\n");
            }
        }
        return degatInflige;
    }

    public boolean VerifpeutAttaquerCorpsACorps(Personnage cible) {
        if (cible != null) {
            if ((this.getY() - 50 <= cible.getY() && cible.getY() <= this.getY() + 50) &&
                    (this.getX() - 50 <= cible.getX() && cible.getX() <= this.getX() + 50)) {
                return true;
            }
        }
        return false;
    }

//    public boolean VerifpeutAttaquerCorpsACorpsEnnemie(Personnage cible) {
//        if (cible != null) {
//            if ((this.getY() - 30 <= cible.getY() && cible.getY() <= this.getY() + 30) &&
//                    (this.getX() - 30 <= cible.getX() && cible.getX() <= this.getX() + 30)) {
//                return true;
//            }
//        }
//        return false;
//    }


    public void attaquerSiAportéeCorpsACorps(Personnage cible) {
        if (VerifpeutAttaquerCorpsACorps(cible)) {
            System.out.println(this.nom + " attaque " + cible.getNom() + " à portée de corps à corps." + "\n");
            attaquer(cible);
        }
    }

//    public boolean peutAttaquerDistance(Personnage cible) {
//
//        if (this instanceof SoldatEnnemi) {
//            if ((this.getY() - 100 <= cible.getY() && cible.getY() <= this.getY() + 100) &&
//                    (this.getX() - 100 <= cible.getX() && cible.getX() <= this.getX() + 100)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean estVivant() {
        return this.getPointVie().getValue() > 0;
    }

    public boolean detecterEnnemi(Personnage personnage) {
        if ((this.getY() - 200 <= personnage.getY() && personnage.getY() <= this.getY() + 200) && this.getX() - 200 <= personnage.getX() && personnage.getX() <= this.getX() + 200) {
            return true;
        }
        return false;
    }

    public void faireApparaitreItemAléatoirement() {

        int x,y;
        boolean positionValide = false;

        do {
            x = (int) (Math.random() * this.getEnvi().getMap().getHauteur() * 38);
            y = (int) (Math.random() * this.getEnvi().getMap().getLargeur() * 38);

            positionValide = !this.getEnvi().getMap().estMur(x,y) && !this.getEnvi().getMap().estLimite(x,y);

        } while (!positionValide);

        this.setX(x);
        this.setY(y);

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



