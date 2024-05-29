package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class BatonMagique extends Arme {
    public BatonMagique() {
        super("BatonMagique", 20);
    }

    @Override
    public String toString() {
        return "Arme" +super.toString() + "point d'attaque : " + getPointsAttaqueArme();
    }
}
