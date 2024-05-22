package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class VueLink {

    private StringProperty direction;
    private ImageView linkImageView;
    private Image linkUp;
    private Image linkDown;
    private Image linkLeft;
    private Image linkRight;
    private Clavier clavier;

    public VueLink(Pane affichagePane, Personnage personnage, TilePane tilePane, Clavier clavier) {
        this.clavier = clavier;
        this.direction = new SimpleStringProperty("down");
        this.linkUp = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_DD.png").toString());
        this.linkDown = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_BG.png").toString());
        this.linkLeft = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_AG.png").toString());
        this.linkRight = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_AD.png").toString());
        afficherLink(affichagePane, personnage, tilePane);
    }

    public void afficherLink(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        Image link = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/Link_baseH.png").toString());
        this.linkImageView = new ImageView(link);
        linkImageView.setFitHeight(25);
        linkImageView.setFitWidth(25);
        linkImageView.setId("#" + personnage.getId());
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, clavier);
        linkImageView.translateXProperty().bind(personnage.getXProperty());
        linkImageView.translateYProperty().bind(personnage.getYProperty());
        affichagePane.getChildren().add(linkImageView);

        direction.addListener((obs, oldDirection, newDirection) -> updateImage());
    }

    public void updateImage() {
        switch (direction.get()) {
            case "up":
                linkImageView.setImage(linkUp);
                break;
            case "down":
                linkImageView.setImage(linkDown);
                break;
            case "left":
                linkImageView.setImage(linkLeft);
                break;
            case "right":
                linkImageView.setImage(linkRight);
                break;
        }
    }

    public void direction(String newDirection) {
        direction.set(newDirection);
    }
}
