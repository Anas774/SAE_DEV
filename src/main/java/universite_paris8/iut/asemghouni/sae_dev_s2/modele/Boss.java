package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Boss extends Personnage {
    public Boss(String nom, int PointVie, Arme arme, Environnement envi) {
        super("Bogo", 115, new Epée(), envi);
    }
}
