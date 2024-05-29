package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Epée extends Arme {
    public Epée() {
        super("Epee", 10);
    }

    @Override
    public String toString() {
        return "Arme" +super.toString() + "point d'attaque : " + getPointsAttaqueArme();
    }

}
