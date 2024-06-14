package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class SoldatEnnemi extends Personnage {

    private Personnage cible;
    private SoldatEnnemi soldatEnnemie;

    public SoldatEnnemi(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("SoldatEnnemie", 100, arme, envi);                                              // 5 coeurs
        this.cible = cible;
        this.faireApparaitreItemAléatoirement();
    }

    public void suivreJoueur2() {

        if (this.estVivant()) {

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

                } else {

                    if (!cible.detectCollision((int) (ennemiX + vitesse), (int) ennemiY)) {
                        this.setX((int) (ennemiX + vitesse));
                    } else if (!cible.detectCollision((int) (ennemiX - vitesse), (int) ennemiY)) {
                        this.setX((int) (ennemiX - vitesse));
                    }

                    if (!cible.detectCollision((int) ennemiX, (int) (ennemiY + vitesse))) {
                        this.setY((int) (ennemiY + vitesse));
                    } else if (!cible.detectCollision((int) ennemiX, (int) (ennemiY - vitesse))) {
                        this.setY((int) (ennemiY - vitesse));
                    }
                }

                attaquerSiAportéeCorpsACorps(cible);

            }
        }
    }

//    private int indiceObstacle(int newX, int newY) {
//
//        int ligne, colonne;
//
//        colonne = newX / 38;
//        ligne = newY / 38;
//
//        return ligne * 15 + colonne;
//    }

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
