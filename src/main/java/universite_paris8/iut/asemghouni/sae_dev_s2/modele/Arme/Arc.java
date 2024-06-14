package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme;

public class Arc extends Arme {

    public Arc() {
        super("Arc", 1);
    }               // demi-coeurs

    @Override
    public String toString() {
        return "Arme : " +super.toString() + " point d'attaque : " + getPointsAttaqueArme();
    }
}
