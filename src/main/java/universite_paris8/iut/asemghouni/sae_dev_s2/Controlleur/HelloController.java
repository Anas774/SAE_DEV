package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur.ObservateurArme;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur.ObservateurItem;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.*;
import javafx.util.Duration;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Epée;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Hache;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.SoldatEnnemi;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    // Attribut Personnage
    private Link link;
    private SoldatEnnemi soldatEnnemi;

    // Attribut VuePersonnage
    private VueLink vueLink;
    private VueEnnemi vueSoldatEnnemi;

    // Attribut concernant gameloop
    private Timeline gameLoop;
    private int temps;

    // Attribut Environnement et Map
    private Map map;
    private Environnement envi;

    // Attribut concernant VueMap
    private VueMap vueMap;

    // Attribut Pane et tilepane
    @FXML
    private Pane affichagePane;
    @FXML
    private TilePane affichageTilePane;

    // Attribut Item
    private Item item;

    // Attribut concernant la vie
    @FXML
    private HBox vieBox;
    private VueVieLink vueVieLink;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);

        this.envi = new Environnement();
        this.map = new Map();

        // Initialiser le personnage principal
        this.link = new Link("Link", 20, new MasterSword(), envi, link);

        // Initialiser le soldat ennemi
        this.soldatEnnemi = new SoldatEnnemi("Ennemi", 10, new Hache(), envi, link);

        // Initialiser le clavier
        Clavier clavier = new Clavier(link, affichagePane, affichageTilePane, map, item);

        ListChangeListener<Item> listen = new ObservateurItem(affichagePane);
        envi.getListeItemEnvi().addListener(listen);

        ListChangeListener<Arme> listen2 = new ObservateurArme(affichagePane);
        envi.getListeArmesEnvi().addListener(listen2);

        // Initialiser les vues
        this.vueMap = new VueMap(affichageTilePane, map);
        this.vueLink = new VueLink(affichagePane, link, affichageTilePane, clavier);
        this.vueSoldatEnnemi = new VueEnnemi(affichagePane, affichageTilePane, soldatEnnemi);
        this.vueVieLink = new VueVieLink(vieBox, link.pointVieProperty());

        clavier.setVueLink(vueLink);

        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, clavier);

        // Observation de la vie de link
        link.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueLink.supprimerVue(affichagePane);
            }
        });

        // Observation de la vie du soldatEnnemi
        soldatEnnemi.pointVieProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() <= 0) {
                vueSoldatEnnemi.supprimerVue(affichagePane);
            }
        });

        // Démarrer l'animation
        animation();
        gameLoop.play();

    }

    @FXML
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
//                        System.out.println("un tour");
                        soldatEnnemi.suivreJoueur2();

                        if (temps % 500 == 0) {
                            for (int i = 0; i < 1; i++) {
                                envi.getListeItemEnvi().add(new Potion("popo", envi));;
                            }
                        }
                        if (temps % 700 == 0) {
                            for (int i = 0; i < 1; i++) {
                                envi.getListeArmesEnvi().add(new Epée());
                            }
                        }
                    }
                    envi.unTour(link);
                    temps++;

                })
        );

        gameLoop.getKeyFrames().add(keyFrame);

    }
}