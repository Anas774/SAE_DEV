package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Epée;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Boss extends Personnage {

    private Personnage cible;

    public Boss(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Bogo", 110, new Epée(),envi);
        this.cible = cible;
        faireApparaitreItemAléatoirement();
    }

    public void suivreJoueur2Boss() {
        if (this.estVivant() && detecterEnnemi(cible)) {
            seDeplacerVersCibleBoss();
            attaquerCibleSiAPorteeBoss();
        }
    }

    public void seDeplacerVersCibleBoss() {
        double joueurX = cible.getX();
        double joueurY = cible.getY();
        double ennemiX = this.getX();
        double ennemiY = this.getY();

        double deltaX = joueurX - ennemiX;
        double deltaY = joueurY - ennemiY;

        double longueur = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        double vitesse = 7;

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
    }

    public void attaquerCibleSiAPorteeBoss() {
        attaquerSiAportéeCorpsACorps(cible);
    }
}
