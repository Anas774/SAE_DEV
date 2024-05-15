package universite_paris8.iut.asemghouni.sae_dev_s2.modele;
public class Arme {

    private int PointAttaque;
    private String nom;

    public Arme(String nom, int PointAttaque) {
        this.nom = nom;
        this.PointAttaque = PointAttaque;
    }
    public int getPointsAttaqueArme() {
        return this.PointAttaque;
    }

    public String toString() {
        return "\nNom de l'arme : " + this.nom;
    }
}
