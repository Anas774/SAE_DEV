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
    private ImageView ennemiImageView;
    private Image linkUp;
    private Clavier clavier;


    public VueEnnemi(Pane affichagePane, TilePane tilePane, SoldatEnnemie soldatEnnemie) {
        creerEnnemi(affichagePane, tilePane, soldatEnnemie);
        meurt(affichagePane,tilePane,soldatEnnemie);
    }

    private void creerEnnemi(Pane affichagePane, TilePane tilePane, SoldatEnnemie soldatEnnemie) {
        Image ennemi = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/zelda.png").toString());
        this.ennemiImageView = new ImageView(ennemi);
        ennemiImageView.setFitWidth(25);
        ennemiImageView.setFitHeight(25);
        ennemiImageView.setId("#" + soldatEnnemie.getId());
        ennemiImageView.translateXProperty().bind(soldatEnnemie.getXProperty());
        ennemiImageView.translateYProperty().bind(soldatEnnemie.getYProperty());
        affichagePane.getChildren().add(ennemiImageView);
    }

    public Personnage getEnnemi() {
        return ennemi;
    }


    public void meurt(Pane affichagePane, TilePane tilePane, SoldatEnnemie soldatEnnemie) {
        Image ennemiMort = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/zeldaMort.png").toString());
        ennemiImageView.translateXProperty().bind(soldatEnnemie.getXProperty());
        ennemiImageView.translateYProperty().bind(soldatEnnemie.getYProperty());
        this.ennemiImageView = new ImageView(ennemiMort);
        if(soldatEnnemie.meurt() ){
            affichagePane.getChildren().add(ennemiImageView);

        }
    }
}
