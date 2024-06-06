package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Link extends Personnage {
    public Link(String nom, int PointVie, Arme arme,Environnement envi) {
        super("Link", 100,new MasterSword(),envi);
    }
}
