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
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.*;

public class VueJoueur {

    private Personnage ennemi;
    private ImageView linkImageView;
    private Image linkUp;
    private Clavier clavier;

    public VueJoueur(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        creeSprite(affichagePane, personnage, tilePane);
    }

    private void creeSprite(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        Image link2 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/link/Link_baseH.png").toString());
        this.linkImageView = new ImageView(link2);
        linkImageView.setFitWidth(25);
        linkImageView.setFitHeight(25);
        linkImageView.setId("#" + personnage.getId());
        linkImageView.translateXProperty().bind(personnage.getXProperty());
        linkImageView.translateYProperty().bind(personnage.getYProperty());
        affichagePane.getChildren().add(linkImageView);
    }





}