package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.beans.property.StringProperty;
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
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.SoldatEnnemie;

public class VueEnnemi {
    private Personnage ennemi;
    private ImageView linkImageView;
    private Image linkUp;
    private Clavier clavier;


    public VueEnnemi(Pane affichagePane, TilePane tilePane, SoldatEnnemie soldatEnnemie) {
        creerEnnemi(affichagePane, tilePane, soldatEnnemie);
    }

    private void creerEnnemi(Pane affichagePane, TilePane tilePane, SoldatEnnemie soldatEnnemie) {
        Image link = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/link/Link_baseH.png").toString());
        this.linkImageView = new ImageView(link);
        linkImageView.setFitWidth(25);
        linkImageView.setFitHeight(25);
        linkImageView.setId("#" + soldatEnnemie.getId());
        linkImageView.translateXProperty().bind(soldatEnnemie.getXProperty());
        linkImageView.translateYProperty().bind(soldatEnnemie.getYProperty());
        affichagePane.getChildren().add(linkImageView);
    }

    public Personnage getEnnemi() {
        return ennemi;
    }
}
