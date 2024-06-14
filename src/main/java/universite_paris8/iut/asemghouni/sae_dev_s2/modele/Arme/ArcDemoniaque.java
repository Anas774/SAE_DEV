package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme;

public class ArcDemoniaque extends Arme {

    public ArcDemoniaque() {
        super("ArcDemoniaque", 20);
    }
    @Override
    public String toString() {
        return "Arme : " + super.toString() + " point d'attaque : " + getPointsAttaqueArme();
    }

}
