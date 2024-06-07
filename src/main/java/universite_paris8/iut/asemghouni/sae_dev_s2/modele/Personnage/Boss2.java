package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arc;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Boss2 extends Personnage {

    private Personnage cible;

    public Boss2(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Kotake", 14, new Arc(), envi);                                       // 7 coeurs
        this.cible = cible;
    }
}
