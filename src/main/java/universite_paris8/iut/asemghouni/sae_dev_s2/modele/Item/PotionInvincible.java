package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;

public class PotionInvincible extends Item {
    public PotionInvincible(String nom, Environnement envi) {
        super("PotionTraversable", envi);
    }

    public void utiliser(Link link) {
        link.effetPotionInvincible();
        this.getEnvi().getListeItemEnvi().remove(this);
    }
}
