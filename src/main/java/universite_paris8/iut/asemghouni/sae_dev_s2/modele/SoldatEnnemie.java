package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import java.util.List;

public class SoldatEnnemie extends Personnage {

    private Personnage cible;
    private SoldatEnnemie soldatEnnemie;

    public SoldatEnnemie(String nom, int PointVie, int PointAttaque, int PointDefense, Arme arme, Environnement envi, int largeur, int hauteur, Personnage cible) {
        super(nom, 60, 30, 30, arme, envi, largeur, hauteur);
        this.cible = cible;
    }

    public void suivreJoueur() {

        double joueurX = cible.getX();
        double joueurY = cible.getY();
        double ennemiX = this.getX();
        double ennemiY = this.getY();

        double vitesse = 4;

        double deltaX = joueurX - ennemiX;
        double deltaY = joueurY - ennemiY;

/*  Methode à faire voir par la prof

        double longueur = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        if (longueur != 0) {
            deltaX = deltaX * vitesse;
            deltaY = deltaY * vitesse;
        }

        this.setX((int)(ennemiX + vitesse));
        this.setY((int)(ennemiY + vitesse));
*/
        if (Math.abs(deltaX) > Math.abs(deltaY)) {

            if (deltaX > 0) {
                this.setX((int) (ennemiX + vitesse));
            } else {
                this.setX((int) (ennemiX - vitesse));
            }

        } else {

            if (deltaY > 0) {
                this.setY((int) (ennemiY + vitesse));
            } else {
                this.setY((int)(ennemiY - vitesse));
            }

        }

    }

//    private boolean detectCollision(int newX, int newY) {
//        List<int[]> coins = this.getCoins(newX, newY);
//        for (int[] coin : coins) {
//            if (this.getEnvi().getMap().estMur(coin[0], coin[1]) || this.getEnvi().getMap().estLimite(coin[0], coin[1])) {
//                return true;
//            }
//        }
//        return false;
//    }
}
