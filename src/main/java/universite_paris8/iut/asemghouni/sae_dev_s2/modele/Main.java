package universite_paris8.iut.asemghouni.sae_dev_s2.modele;
//sert à vérifé le bon fonctionnement du système des Armes, attaque, perso choisie
public class Main {
    public static void main(String[] args) {
        Environnement envi=new Environnement();
        Arme arme=new Arme("arme Ennemi",10);
        Arme armeL=new Arme("arme Link",10);
        Personnage link=new Personnage("Link",50,10,10,armeL,envi);
        SoldatEnnemie ennemie=new SoldatEnnemie("AFO",10,10,10,arme,envi,link,300,50);
        System.out.println(ennemie.attaque(link));
        link.subirDegats(10);

    }
}