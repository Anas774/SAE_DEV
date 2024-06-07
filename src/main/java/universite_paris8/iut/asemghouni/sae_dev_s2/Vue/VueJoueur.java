package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class VueJoueur {

    private Personnage personnage;
    private ImageView linkImageView;
    private Image linkImage;
    Item item;

    public VueJoueur(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        this.personnage = personnage;
        this.item=new Item("blabla",new Environnement());
        creeSprite(affichagePane, personnage, tilePane);
    }

    private void creeSprite(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        linkImage = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/link/Link_baseH.png").toString());
        linkImageView = new ImageView(linkImage);
        linkImageView.setFitWidth(25);
        linkImageView.setFitHeight(25);
        linkImageView.setId("#" + personnage.getId());
        linkImageView.translateXProperty().bind(personnage.getXProperty());
        linkImageView.translateYProperty().bind(personnage.getYProperty());
        affichagePane.getChildren().add(linkImageView);
        }
    }

