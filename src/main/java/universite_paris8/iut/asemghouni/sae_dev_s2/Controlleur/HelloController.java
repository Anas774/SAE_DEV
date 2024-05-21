package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.animation.KeyFrame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueJoueur;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueLink;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueMap;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.*;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class HelloController implements Initializable {
    private Personnage personnage;
    private Map map;
    private VueMap vueMap;
    private VueJoueur vueJoueur;
    private VueLink vueLink;
    @FXML
    private Pane affichagePane;
    @FXML
    private TilePane affichageTilePane;
    private Timeline gameLoop;
    private int temps;
    @FXML
    private Circle leCercle;
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        initAnimation();
        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);
        this.map = new Map();
        this.personnage = new Personnage();
        this.vueMap = new VueMap(affichageTilePane, map);
        this.vueJoueur = new VueJoueur(affichagePane, personnage, affichageTilePane);
        this.vueLink = new VueLink(affichagePane,personnage,affichageTilePane);
        Clavier x = new Clavier(personnage, affichagePane, affichageTilePane,map);
//        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, x);
    }
    public void mouseClicked(MouseEvent mouseEvent) {
        affichagePane.requestFocus();
    }
//    private void initAnimation() {
//        gameLoop = new Timeline();
//        temps=0;
//        gameLoop.setCycleCount(Timeline.INDEFINITE);
//
//        KeyFrame kf = new KeyFrame(
//                // on définit le FPS (nbre de frame par seconde)
//                Duration.seconds(0.017),
//                // on définit ce qui se passe à chaque frame
//                // c'est un eventHandler d'ou le lambda
//                (ev ->{
//                    if(temps==100){
//                        System.out.println("fini");
//                        gameLoop.stop();
//                    }
//                    else if (temps%5==0){
//                        System.out.println("un tour");
//                        leCercle.setLayoutX(leCercle.getLayoutX()+5);
//                        leCercle.setLayoutY(leCercle.getLayoutY()+5);
//
//                    }
//                    temps++;
//                })
//        );
//        gameLoop.getKeyFrames().add(kf);
//    }

}