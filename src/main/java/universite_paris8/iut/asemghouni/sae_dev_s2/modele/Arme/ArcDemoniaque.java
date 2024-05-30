package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme;

public class ArcDemoniaque extends Arme {

    public ArcDemoniaque() {
        super("ArcDemoniaque", 10);
    }//+5 de dégâts qu'un arc classique

    @Override
    public String toString() {
        return "Arme" +super.toString() + "point d'attaque : " + getPointsAttaqueArme();
    }

}
