package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import java.util.List;

public class SoldatEnnemie extends Personnage {

    private Personnage cible;
    private SoldatEnnemie soldatEnnemie;

    public SoldatEnnemie(String nom, int PointVie, int PointAttaque, int PointDefense, Arme arme, Environnement envi, Personnage cible) {
        super(nom, 60, 30, 30, arme, envi);
        this.cible = cible;
    }

    public void suivreJoueur2() {

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
        else {
            int[] deplacement = {};
        }
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
//        double vitesse = 3;
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
