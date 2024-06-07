package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Epée;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Boss extends Personnage {

    private Personnage cible;
    public Boss(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Bogo", 14, new Epée(),envi);                                         // 7 coeurs
        this.cible = cible;
    }
}
