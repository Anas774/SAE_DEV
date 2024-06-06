package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Fleche extends Item {
    private int nombre;

    public Fleche(String nom, Environnement envi, int nombre) {
        super("nom", envi);
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Une flèche !";
    }
}
