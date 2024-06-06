package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement;

public class SoldatEnnemie extends Personnage {

    private Personnage cible;
    private SoldatEnnemie soldatEnnemie;

    public SoldatEnnemie(String nom, int PointVie, int PointAttaque, int PointDefense, Arme arme, Environnement envi, Personnage cible) {
        super(nom, 60, 30, 30, arme, envi);
        this.cible = cible;
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
            double vitesse = 4;

            if (longueur != 0) {
                deltaX = (deltaX / longueur) * vitesse;
                deltaY = (deltaY / longueur) * vitesse;
            }

            if (!cible.detectCollision((int) ennemiX, (int) ennemiY)) {
                this.setX((int) (ennemiX + deltaX));
                this.setY((int) (ennemiY + deltaY));

            }
        }
    }

//        else {
//
//        double[] direction = {vitesse, -vitesse, vitesse / 2, -vitesse / 2};
//        boolean bouger = false;
//
//        for (double directionX : direction) {
//            for (double directionY : direction) {
//                double nouveauX = ennemiX + directionX;
//                double nouveauY = ennemiY + directionY;
//
//                if (!clavier.detectCollision((int) nouveauX, (int) nouveauY)) {
//                    this.setX((int) nouveauX);
//                    this.setY((int) nouveauY);
//                    bouger = true;
//                    break;
//                }
//            }
//            if (bouger) {
//                break;
//            }
//        }

//        if (!bouger) {
//            System.out.println("L'ennemi est bloqué !");

    private boolean detecterEnnemi(Personnage personnage) {
        if ((this.getY() - 200 <= personnage.getY() && personnage.getY() <= this.getY() + 200) && this.getX() - 200 <= personnage.getX() && personnage.getX() <= this.getX() + 200) {
            return true;
        }
        return false;
    }
}

//    public void suivreJoueur() {
//
//        double joueurX = cible.getX();
//        double joueurY = cible.getY();
//
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
//    }


