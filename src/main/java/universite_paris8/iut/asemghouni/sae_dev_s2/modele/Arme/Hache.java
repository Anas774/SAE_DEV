package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme;

public class Hache extends Arme {
    public Hache() {
        super("Hache", 2);
    }
    @Override
    public String toString() {
        return "Arme : " +super.toString() + " point d'attaque : " + getPointsAttaqueArme();
    }
}
