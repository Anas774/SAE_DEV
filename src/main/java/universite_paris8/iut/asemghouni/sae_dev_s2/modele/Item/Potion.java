package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;

public class Potion extends Item {
    private int valeurRecuperationVie;

    public Potion(String nom, Environnement envi) {
        super("PotionDeVie",envi);
        this.valeurRecuperationVie = 1;
    }

    public void utiliser(Link link) {
        link.recupererVie(valeurRecuperationVie);
        this.getEnvi().getListeItemEnvi().remove(this);
    }
}
