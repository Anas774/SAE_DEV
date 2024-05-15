package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;

public class VueMap {
    private ImageView vue;
    public VueMap(TilePane tilePane, Map mapJeu) {
        creerMap(tilePane, mapJeu);
    }


    public void creerMap(TilePane tilePane, Map mapJeu) {
        double tileHauteur = tilePane.getPrefTileHeight();
        double tileLargeur = tilePane.getPrefTileWidth();

            /*import d'image pour remplacer les couleurs par des tuiles (herbe,terre....)*/
        Image herbe = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/image/herbe.png").toString());
        Image terre = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/image/terre.png").toString());
        Image eau = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/image/eau.png").toString());
            /*Parcour du tab qui met les images (tuiles) en fonction des valeurs du tab*/
        for (int i = 0; i < mapJeu.getMapJeu().length; i++) {
            vue=new ImageView();
            if (mapJeu.getMapJeu()[i] == 1) {
                vue.setImage(herbe);
            } else if (mapJeu.getMapJeu()[i] == 5) {
                vue.setImage(terre);
            } else {
                vue.setImage(eau);
            }
            tilePane.getChildren().add(vue);
        }
    }
}
