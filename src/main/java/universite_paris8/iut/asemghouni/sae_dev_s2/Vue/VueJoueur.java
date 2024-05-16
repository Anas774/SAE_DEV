package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class VueJoueur {

    public VueJoueur(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        creeSprite(affichagePane, personnage, tilePane);
    }

    private void creeSprite(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        Circle circle = new Circle(10);
        circle.setFill(Color.BLACK);
        circle.setId("#" + personnage.getId());
        Clavier x = new Clavier(personnage, affichagePane, tilePane);
        affichagePane.addEventFilter(KeyEvent.KEY_PRESSED, x);
        circle.translateXProperty().bind(personnage.getXProperty());
        circle.translateYProperty().bind(personnage.getYProperty());
        affichagePane.getChildren().add(circle);
    }

}
