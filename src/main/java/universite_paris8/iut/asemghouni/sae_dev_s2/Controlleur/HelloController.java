package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.input.KeyEvent;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Translate;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur.ObservateurItem;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.*;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.*;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.*;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.*;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.*;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private Personnage personnage;
    private VueLink vueLink;
    private VueJoueur vueJoueur;
    private Timeline gameLoop;
    private int temps;
    private Map map;
    private VueMap vueMap;
    private VueEnnemi vueEnnemi;
    private SoldatEnnemie soldatEnnemie;
    private Environnement envi;

    @FXML
    private Pane affichagePane;
    @FXML
    private TilePane affichageTilePane;

    private Item item;
    private VueVie vueVie;
    @FXML
    private HBox vieBox;

    private VueArme vueArme;
    private Arme epee;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);

        this.envi = new Environnement();
        this.map = new Map();
        this.personnage = new Personnage("Link", 20, new Hache(), envi);
        this.soldatEnnemie = new SoldatEnnemie("Ennemi", 8, new Hache(), envi, personnage);
        Clavier clavier = new Clavier(personnage, affichagePane, affichageTilePane, map, item);

        this.vueMap = new VueMap(affichageTilePane, map);
        this.vueLink = new VueLink(affichagePane, personnage, affichageTilePane, clavier);
        this.vueEnnemi = new VueEnnemi(affichagePane, affichageTilePane, soldatEnnemie);
        this.vueVie = new VueVie(vieBox, personnage.pointVieProperty());

        clavier.setVueLink(vueLink);

        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, clavier);

        ListChangeListener<Item> listen = new ObservateurItem(affichagePane);
        envi.getListeItemEnvi().addListener(listen);

        animation();
        gameLoop.play();
    }

    @FXML
    public void mouseClicked(MouseEvent mouseEvent) {
        affichagePane.requestFocus();
    }

    private void scrollingMap(Personnage perso) {
        this.personnage=personnage;
        double characterX = personnage.getX();
        double characterY = personnage.getY();
        System.out.println("Personnage position: (" + characterX + ", " + characterY + ")");

        // Calculer les nouvelles positions de la caméra
        double offsetX = characterX - affichagePane.getWidth() / 2;
        double offsetY = characterY - affichagePane.getHeight() / 2;

        // Limiter le défilement pour ne pas sortir de la carte
        offsetX = Math.max(0, Math.min(offsetX, map.getLargeur() * 38 - affichagePane.getWidth()));
        offsetY = Math.max(0, Math.min(offsetY, map.getHauteur() * 38 - affichagePane.getHeight()));

        // Déplacer le pane
        affichagePane.getTransforms().clear();
        affichagePane.getTransforms().add(new Translate(-offsetX, -offsetY));

        System.out.println("Camera centré à : (" + offsetX + ", " + offsetY + ")");
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
                        soldatEnnemie.suivreJoueur2();
                        if (temps % 300 == 0) {
                            for (int i = 0; i < 1; i++) {
                                envi.getListeItemEnvi().add(new Potion("popo", envi));
                            }
                        }
                    }
                    envi.unTour(personnage);
                    scrollingMap(personnage);
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(keyFrame);
    }
}
