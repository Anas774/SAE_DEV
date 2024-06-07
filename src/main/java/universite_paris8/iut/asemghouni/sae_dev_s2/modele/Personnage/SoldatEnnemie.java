package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

import java.util.Timer;
import java.util.TimerTask;

public class SoldatEnnemie extends Personnage {

    private Personnage cible;
    private SoldatEnnemie soldatEnnemie;

    public SoldatEnnemie(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("SoldatEnnemie", 10, arme, envi);                                              // 5 coeurs
        this.cible = cible;
        faireApparaitreItemAléatoirement();

    }

    public void suivreJoueur2() {

        if (detecterEnnemi(cible)) {

            double joueurX = cible.getX();
            double joueurY = cible.getY();
            double ennemiX = this.getX();
            double ennemiY = this.getY();

            double deltaX = joueurX - ennemiX;
            double deltaY = joueurY - ennemiY;

            double longueur = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            double vitesse = 8;

            if (longueur != 0) {
                deltaX = (deltaX / longueur) * vitesse;
                deltaY = (deltaY / longueur) * vitesse;
            }

            if (!cible.detectCollision((int) ennemiX, (int) ennemiY)) {
                this.setX((int) (ennemiX + deltaX));
                this.setY((int) (ennemiY + deltaY));
            }

            attaquerSiAportée(cible);

        }
    }

    private boolean detecterEnnemi(Personnage personnage) {
        if ((this.getY() - 200 <= personnage.getY() && personnage.getY() <= this.getY() + 200) && this.getX() - 200 <= personnage.getX() && personnage.getX() <= this.getX() + 200) {
            return true;
        }
        return false;
    }

    private void attaquerSiAportée(Personnage cible) {
        if (peutAttaquerCorpsACorps(cible)) {
            attaquer(cible);
        }
    }

    private void faireApparaitreItemAléatoirement() {

        int x,y;

        do {
            x = (int) (Math.random() * this.getEnvi().getMap().getHauteur() * 38);
            y = (int) (Math.random() * this.getEnvi().getMap().getLargeur() * 38);

        } while (this.getEnvi().getMap().getMapJeu()[indiceObstacle(x,y)] == 5 && !this.getEnvi().getMap().estLimite(x,y));

        this.setX(x);
        this.setY(y);

    }

    private int indiceObstacle(int newX, int newY) {

        int ligne, colonne;

        colonne = newX / 38;
        ligne = newY / 38;

        return ligne * 15 + colonne;
    }

//    public void suivreJoueur() {
//
//        double joueurX = cible.getX();
//        double joueurY = cible.getY();
//        double ennemiX = this.getX();
//        double ennemiY = this.getY();
//
//        double deltaX = joueurX - ennemiX;
//        double deltaY = joueurY - ennemiY;
//
//        double vitesse = 5;
//
//        if (Math.abs(deltaX) > Math.abs(deltaY)) {
//
//            if (deltaX > 0) {
//                this.setX((int) (ennemiX + vitesse));
//            } else {
//                this.setX((int) (ennemiX - vitesse));
//            }
//
//        } else {
//
//            if (deltaY > 0) {
//                this.setY((int) (ennemiY + vitesse));
//            } else {
//                this.setY((int) (ennemiY - vitesse));
//            }
//
//        }
//
//    }

}
