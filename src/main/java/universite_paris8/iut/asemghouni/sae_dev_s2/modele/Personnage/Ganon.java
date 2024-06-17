package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.EpeeDuDieuBestial;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Ganon extends Personnage {

    private Personnage cible;

    public Ganon(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Ganon", 200, new EpeeDuDieuBestial(), envi);
        this.cible = cible;
        faireApparaitrePersoAleatoirement();
    }

    public void suivreJoueur2Ganon() {
        if (this.estVivant() && detecterEnnemi(cible)) {
            seDeplacerVersCibleGanon();
            attaquerCibleSiAPorteeGanon();
        }
    }

    public void seDeplacerVersCibleGanon() {
        double joueurX = cible.getX();
        double joueurY = cible.getY();
        double ennemiX = this.getX();
        double ennemiY = this.getY();

        double deltaX = joueurX - ennemiX;
        double deltaY = joueurY - ennemiY;

        double longueur = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        double vitesse = 5;

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

    public void attaquerCibleSiAPorteeGanon() {
        attaquerSiAportéeCorpsACorps(cible);
    }
}
