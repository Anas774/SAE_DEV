package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Potion extends Item {
    private int valeur;

    public Potion(String nom, Environnement envi) {
        super("Potion de shield", envi);
        this.valeur = 10;
    }
    public void apparitionPotion() {

    }

}
