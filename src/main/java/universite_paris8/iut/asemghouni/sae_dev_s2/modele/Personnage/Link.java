package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Link extends Personnage {
    private Personnage cible;
    private List<Item> itemPossederParLink;

    public Link(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Link", 20, new MasterSword(), envi);                                 // 10 coeurs
        this.cible = cible;
        this.itemPossederParLink = new ArrayList<>();

    }

    public List<Item> getItems() {
        return itemPossederParLink;
    }

    public void ramasserItem(Item item) {
        itemPossederParLink.add(item);
    }

    public void recupererVie(int points) {

        int pointVieActuelle = this.getPointVie().get();

        pointVieActuelle = pointVieActuelle + points;

        if (pointVieActuelle > 20) {
            pointVieActuelle = 20;
        }
        this.getPointVie().set(pointVieActuelle);
    }


}
