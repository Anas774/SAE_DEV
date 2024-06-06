package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;


import java.util.ArrayList;

public class Environnement {

    private Map map;

    //    private ObservableList<Personnage> personnage;
    private ObservableList<Item> listeItemEnvi;

    public Environnement() {
        this.map = new Map();
        this.listeItemEnvi = FXCollections.observableArrayList();
        //        this.personnage = FXCollections.observableArrayList();
    }

    public Map getMap() {
        return this.map;
    }

    //    public ObservableList<Personnage> getPersonnages() {
    //        return this.personnage;
    //    }

    //    public void ajouter(Personnage personnage) {
    //        this.personnage.add(personnage);
    //    }

    public ObservableList<Item> getListeItemEnvi(){
        return this.listeItemEnvi;
    }

    public void ajouter(Item item){
        this.listeItemEnvi.add(item);
    }

    public void unTour(Personnage personnage) {

        Item itemRamasable = estRamasable(personnage);

        if (itemRamasable != null) {

            System.out.println("Item ramassé : " + itemRamasable.getNom());
            listeItemEnvi.remove(itemRamasable);
        }
    }

    public Item estRamasable(Personnage personnage) {
        for (Item item : listeItemEnvi) {
            if ((personnage.getY() - 20 <= item.getY() && item.getY() <= personnage.getY() + 20) &&
                    (personnage.getX() - 20 <= item.getX() && item.getX() <= personnage.getX() + 20)) {
                return item;
            }
        }
        System.out.println("Pas d'item à côté");
        return null;
    }

}

