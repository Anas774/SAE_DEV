package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.SoldatEnnemie;

public class VueEnnemi {
    private Personnage ennemi;
    private ImageView ennemiImageView;
    private Image linkUp;
    private Clavier clavier;


    public VueEnnemi(Pane affichagePane, TilePane tilePane, SoldatEnnemie soldatEnnemie) {
        creerEnnemi(affichagePane, tilePane, soldatEnnemie);
    }

    private void creerEnnemi(Pane affichagePane, TilePane tilePane, SoldatEnnemie soldatEnnemie) {
        Image ennemi = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/ennemi.png").toString());
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
}
