package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Ganon extends Personnage {

    public Ganon(String nom, int PointVie, Arme arme, Environnement envi) {
        super("Ganon", 150, new EpeeDuDieuBestial(),envi);
    }
}
