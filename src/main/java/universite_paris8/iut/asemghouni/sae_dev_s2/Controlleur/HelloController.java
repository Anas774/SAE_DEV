package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur.ObservateurItem;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.*;
import javafx.util.Duration;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.*;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Hache;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Potion;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.SoldatEnnemie;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    private VueItem vueItem;
    private Item item;

    private VueVie vueVie;
    @FXML
    private HBox vieBox;

    private VueVieEnnemi vueVieEnnemi;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);

        this.envi = new Environnement();
        this.map = new Map();

        Item item = new Potion("popo1",envi);
        Item item1 = new Potion("popo2",envi);

        // Ajoute l'item a l'envi
        this.envi.ajouter(item);
        this.envi.ajouter(item1);

        // Initialiser le personnage principal
        this.personnage = new Personnage("Lokmen", 100,10,10,new Hache(), envi);


        // Initialiser le soldat ennemi
        this.soldatEnnemie = new SoldatEnnemie("Ennemi", 60, 30, 30, null, envi, personnage);

        // Initialiser le clavier
        Clavier clavier = new Clavier(personnage, affichagePane, affichageTilePane, map, item);

        // Initialiser les vues
        this.vueMap = new VueMap(affichageTilePane, map);
        this.vueItem = new VueItem(affichagePane,item);
        this.vueLink = new VueLink(affichagePane, personnage, affichageTilePane, clavier);
        this.vueEnnemi = new VueEnnemi(affichagePane, affichageTilePane, soldatEnnemie);
        this.vueVie = new VueVie(vieBox,personnage.pointVieProperty());
        this.vueVieEnnemi = new VueVieEnnemi(soldatEnnemie.pointVieProperty(), soldatEnnemie,affichagePane);

        clavier.setVueLink(vueLink);

        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, clavier);

        miseAJourVie();

        // Démarrer l'animation
        animation();
        gameLoop.play();
    }

    public void miseAJourVie() {
        personnage.setPointVie(10);
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
                          soldatEnnemie.suivreJoueur2();
                    }
                    temps++;
                })
        );

        gameLoop.getKeyFrames().add(keyFrame);

    }
}
