package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueJoueur;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueMap;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class HelloController implements Initializable {
    private Personnage personnage;
    private VueMap vueMap;
    private VueJoueur vueJoueur;
    private Timeline gameLoop;
    private int temps;
    private Map map;

    @FXML
    private Pane affichagePane;
    @FXML
    private TilePane affichageTilePane;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);
        this.map = new Map();
        this.personnage = new Personnage();
        this.vueMap = new VueMap(affichageTilePane, map);
        this.vueJoueur = new VueJoueur(affichagePane, personnage, affichageTilePane);

        Clavier x = new Clavier(personnage, affichagePane, affichageTilePane,map);
        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, x);

        animation();
        gameLoop.play();
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        affichagePane.requestFocus();
    }

    private void animation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.017),
                (ev -> {
                    if (temps == 10000) {
                        System.out.println("fin");
                        gameLoop.stop();
                    } else if (temps % 5 == 0) {
                        System.out.println("un tour");
                        vueJoueur.getEnnemi().setX(vueJoueur.getEnnemi().getX() + 5);
                        vueJoueur.getEnnemi().setY(vueJoueur.getEnnemi().getY() + 5);
                    }
                    temps++;
                })
        );

        gameLoop.getKeyFrames().add(keyFrame);
    }
}
