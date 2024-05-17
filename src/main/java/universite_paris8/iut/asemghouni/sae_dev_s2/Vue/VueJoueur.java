package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class VueJoueur {
    ImageView vue;
    Clavier touche;


    public VueJoueur(Pane pane, Personnage personnage) {
        this.vue = new ImageView();
        this.touche = new Clavier(personnage, pane);
        creeSprite(pane, personnage);
    }



    private void creeSprite(Pane pane, Personnage personnage) {
        Circle circle = new Circle(10);
        circle.setFill(Color.BLACK);
        circle.setId("#" + personnage.getId());
        Clavier x = new Clavier(personnage, pane);
        pane.addEventFilter(KeyEvent.KEY_PRESSED, x);
        circle.translateXProperty().bind(personnage.getXProperty());
        circle.translateYProperty().bind(personnage.getYProperty());
        pane.getChildren().add(circle);

    }

}






