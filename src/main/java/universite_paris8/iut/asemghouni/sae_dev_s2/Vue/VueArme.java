package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;

public class VueArme {

    private Arme arme;
    private Image epee;
    private ImageView imageViewEpee;
    private Clavier clavier;

    public VueArme(Pane affichagePane, Arme arme) {
        this.arme = arme;
        creerEpee(affichagePane,arme);
    }

    private void creerEpee(Pane affichagePane, Arme arme) {
        Image imageEpee = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/image/sword_normal.png"));
        this.imageViewEpee =  new ImageView(imageEpee);
        imageViewEpee.setFitHeight(15);
        imageViewEpee.setFitWidth(15);
        imageViewEpee.setId(arme.getId());
        imageViewEpee.translateXProperty().bind(arme.getXProperty());
        imageViewEpee.translateYProperty().bind(arme.getYProperty());
        affichagePane.getChildren().add(imageViewEpee);
    }

}
