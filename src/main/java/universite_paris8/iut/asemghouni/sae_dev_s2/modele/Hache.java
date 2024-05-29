package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Hache extends Arme {
    public Hache() {
        super("Hache", 10);
    }
    @Override
    public String toString() {
        return "Arme" +super.toString() + "point d'attaque : " + getPointsAttaqueArme();
    }
}
