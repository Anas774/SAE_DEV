package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueVie;

public class SoldatEnnemie extends Personnage {
    private Pane pane;
    private TilePane tilepane = new TilePane();
    private Personnage cible;
    private VueVie vueVie;

    public SoldatEnnemie(String nom, int PointVie, int PointAttaque, int PointDefense, Arme arme, Environnement envi, Personnage cible, int startX, int startY) {
        super(nom, PointVie, PointAttaque, PointDefense, arme, envi);
        this.cible = cible;
        this.setX(startX);
        this.setY(startY);
        vueVie = new VueVie(tilepane, cible, pane);
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

            if (attaque(cible)) { // Vérifier si l'ennemi a atteint la cible
                System.out.println(cible.getNom()+" à été attaquée par " + getNom());
                cible.subirDegats(this.getPointAttaque());
                System.out.println("dégats : "+ this.getPointAttaque());
                vueVie.setVie(cible.getPointVie());
                // Si la vie de la cible est maintenant inférieure à vieBase, vide un cœur
                if (this.getPointAttaque() >= 10) {
                    vueVie.viderUnCoeur();
                }
            }
        }
     }

     public boolean meurt(){
        if(getPointVie()==0){
            System.out.println(this.getNom() + " est mort !");
        }
         return false;
     }
}
