package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Link extends Personnage {
    private Personnage cible;

    public Link(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Link", 100, new MasterSword(), envi);
        this.cible = cible;
    }

}
