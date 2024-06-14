package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme;

public class EpeeDuDieuBestial extends Arme {
    public EpeeDuDieuBestial() {
        super("EpeeDuDieuBestial", 6);              // 3 coeurs
    }
    @Override
    public String toString() {
        return "Arme : " +super.toString() + " point d'attaque : " + getPointsAttaqueArme();
    }
}
