package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Arc extends Arme {

    public Arc() {
        super("Arc", 5);
    }

    @Override
    public String toString() {
        return "Arme" +super.toString() + "point d'attaque : " + getPointsAttaqueArme();
    }
}
