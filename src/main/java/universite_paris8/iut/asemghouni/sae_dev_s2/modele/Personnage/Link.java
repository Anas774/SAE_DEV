package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Link extends Personnage {
    private Personnage cible;
    private ObservableList<Item> itemPossederParLink;
    private ObservableList<Arme> armePossederParLink;

    public Link(String nom, int PointVie, Arme arme, Environnement envi, Personnage cible) {
        super("Link", 20, new MasterSword(), envi);                                 // 10 coeurs
        this.cible = cible;
        this.itemPossederParLink = FXCollections.observableArrayList();
        this.armePossederParLink = FXCollections.observableArrayList();
    }

    public ObservableList<Item> getItems() {
        return itemPossederParLink;
    }

    public void ramasserItem(Item item) {
        itemPossederParLink.add(item);
    }

    public void retirerItem(Item item) {
        itemPossederParLink.remove(item);
    }

    public ObservableList<Arme> getArmePossederParLink() {
        return armePossederParLink;
    }

    public void ramasserArme(Arme arme) {
        armePossederParLink.add(arme);
    }

    public void retirerArme(Arme arme) {
        armePossederParLink.remove(arme);
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
