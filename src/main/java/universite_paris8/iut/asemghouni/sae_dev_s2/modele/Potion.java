package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Potion extends Item {
    private int valeur;

    public Potion(String nom, Environnement envi, int valeur) {
        super("nom", envi);
        this.valeur = valeur;
    }
    public void apparitionPotion() {

    }

}
