package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;

public class Bombe extends Item {

    private int nombre;

    public Bombe(String nom, Environnement envi) {
        super("Bombe", envi);
        this.nombre = 0;
    }
}
