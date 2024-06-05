package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arc;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Boss2 extends Personnage {

    private Personnage cible;

    public Boss2(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Kotake", 115, new Arc(), envi);
        this.cible = cible;
    }
}
