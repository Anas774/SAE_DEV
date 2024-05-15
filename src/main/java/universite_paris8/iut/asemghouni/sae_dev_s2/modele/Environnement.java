package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


import java.util.ArrayList;

public class Environnement {

    private int width;
    private int height;
    private ObservableList<Personnage> personnage;

    public Environnement(int width, int height) {
        this.width = width;
        this.height = height;
        this.personnage = FXCollections.observableArrayList();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ObservableList<Personnage> getPersonnages() {
        return this.personnage;
    }

    public void ajouter(Personnage personnage) {
        this.personnage.add(personnage);
    }


//    public void afficherMap() {
//        for (int i = 0; i < mapJeu.length; i++) {
//            for (int j = 0; j < mapJeu.length; j++) {
//                System.out.println(mapJeu[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }


}
