package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class Fleche extends Item {
    private int nombre;

    public Fleche(String nom, Environnement envi) {
        super("Fleche",envi);
        this.nombre = 0;

    }

//    public void ramasser() {
//
//    }

}
