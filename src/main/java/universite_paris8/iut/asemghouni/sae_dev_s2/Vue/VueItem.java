package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.*;

public class VueItem {

    private Item item;
    private ImageView itemImageview;
    private Image itemH;
    private Clavier clavier;

    public VueItem(Pane affichagePane, Item item, TilePane tilePane) {
        creeItem(affichagePane, item, tilePane);
    }

    private void creeItem(Pane affichagePane, Item item, TilePane tilePane) {
        Image item1 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/potion_bleu.png").toString());
        this.itemImageview = new ImageView(item1);
        itemImageview.setFitWidth(15);
        itemImageview.setFitHeight(15);
        itemImageview.setId("#" + item.getId());
        itemImageview.translateXProperty().bind(item.getXProperty());
        itemImageview.translateYProperty().bind(item.getYProperty());
        affichagePane.getChildren().add(itemImageview);
    }

}