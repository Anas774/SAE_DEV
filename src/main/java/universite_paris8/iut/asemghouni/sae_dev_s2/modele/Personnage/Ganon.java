package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.EpeeDuDieuBestial;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Ganon extends Personnage {

    private Personnage cible;

    public Ganon(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Ganon", 120, new EpeeDuDieuBestial(), envi);
        this.cible = cible;
    }
}
