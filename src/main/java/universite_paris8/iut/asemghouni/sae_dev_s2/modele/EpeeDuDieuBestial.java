package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class EpeeDuDieuBestial extends Arme {
    public EpeeDuDieuBestial() {
        super("EpeeDuDieuBestial", 15);
    }
    @Override
    public String toString() {
        return "Arme" +super.toString() + "point d'attaque : " + getPointsAttaqueArme();
    }
}
