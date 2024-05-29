package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


import java.util.ArrayList;

public class Environnement {

    private Map map;
    private ObservableList<Personnage> personnage;
    private ObservableList<Item> item;

    public Environnement() {
        this.map = new Map();
//        this.personnage = FXCollections.observableArrayList();
    }

    public Map getMap() {
        return this.map;
    }

    public ObservableList<Personnage> getPersonnages() {
        return this.personnage;
    }

    public void ajouter(Personnage personnage) {
        this.personnage.add(personnage);
    }

    public ObservableList<Item> getItem(){
        return this.item;
    }

    public void ajouter(Item item){
        this.item .add(item);
    }


}

