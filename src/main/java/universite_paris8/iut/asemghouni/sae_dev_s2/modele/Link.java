package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Link extends Personnage {
   public Link( Environnement envi) {
        super("Link", 100, 20, 20, new Arme("MasterSword",30),envi);
    }

    //pour attaquer les ennemis
    @Override
    public boolean attaque(Personnage cible) {
        return super.attaque(cible);
    }

}
