package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arc;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Boss2 extends Personnage {

    private Personnage cible;

    public Boss2(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Kotake", 115, new Arc(), envi);
        this.cible = cible;
        faireApparaitreItemAléatoirement();
    }

    public void suivreJoueur2Boss2() {
        if (this.estVivant() && detecterEnnemi(cible)) {
            seDeplacerVersCibleBoss2();
            attaquerCibleSiAPorteeBoss2();
        }
    }

    public void seDeplacerVersCibleBoss2() {
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

    public void attaquerCibleSiAPorteeBoss2() {
        attaquerSiAportéeCorpsACorps(cible);
    }
}
