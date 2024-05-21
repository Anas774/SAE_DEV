package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class VueLink {

    public VueLink(Pane affichagePane,Personnage personnage, TilePane tilePane) {
        afficherLink(affichagePane,personnage,tilePane);
    }

    public void afficherLink(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        Image link = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base.png").toString());
        ImageView linkImageView = new ImageView(link);
        linkImageView.setFitHeight(25);
        linkImageView.setFitWidth(25);
        linkImageView.setId("#" + personnage.getId());
        Clavier cla = new Clavier(personnage,affichagePane,tilePane,new Map());
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, cla);
        linkImageView.translateXProperty().bind(personnage.getXProperty());
        linkImageView.translateYProperty().bind(personnage.getYProperty());
        affichagePane.getChildren().add(linkImageView);
    }

}
