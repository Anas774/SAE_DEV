package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;

public class VueLink {

    private StringProperty direction;
    private ImageView linkImageView;
    private Image linkUp, linkUp1;
    private Image linkDown, linkDown1;
    private Image linkLeft, linkLeft1;
    private Image linkRight, linkRight1;
    private Clavier clavier;
    private boolean alterner;

    public VueLink(Pane affichagePane, Personnage personnage, TilePane tilePane, Clavier clavier) {
        this.clavier = clavier;
        this.direction = new SimpleStringProperty("down");
        this.linkUp = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_DD.png").toString());
        this.linkUp1 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_DG.png").toString());

        this.linkDown = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_BG.png").toString());
        this.linkDown1 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_BD.png").toString());

        this.linkLeft = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_AG.png").toString());
        this.linkLeft1 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_baseG.png").toString());

        this.linkRight = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_base_AD.png").toString());
        this.linkRight1 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/link_baseD.png").toString());

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
    }

    public void modifImage() {
        switch (direction.get()) {
            case "up":
                linkImageView.setImage(alterner ? linkUp : linkUp1);
                break;
            case "down":
                linkImageView.setImage(alterner ? linkDown : linkDown1);
                break;
            case "left":
                linkImageView.setImage(alterner ? linkLeft : linkLeft1);
                break;
            case "right":
                linkImageView.setImage(alterner ? linkRight : linkRight1);
                break;
        }
    }

    public void setdirection(String newDirection) {
        direction.set(newDirection);
        alterner = !alterner;
        modifImage();
    }

    public void update(Personnage personnage) {
        modifImage();
    }
}
