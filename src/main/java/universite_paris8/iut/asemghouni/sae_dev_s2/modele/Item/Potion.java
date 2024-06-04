package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Potion extends Item {
    private int valeur;

    public Potion(String nom, Environnement envi) {
        super(nom,envi);
        this.valeur = 10;
    }
}
