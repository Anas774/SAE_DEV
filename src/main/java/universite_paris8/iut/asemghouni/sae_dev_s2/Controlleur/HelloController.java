package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.*;
import javafx.util.Duration;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.*;
import java.net.URL;
import java.util.ResourceBundle;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

public class HelloController implements Initializable {
    private Personnage personnage;
    private VueMap vueMap;
    private VueLink vueLink;
    private VueJoueur vueJoueur;
    private Timeline gameLoop;
    private int temps;
    private Map map;
    private VueEnnemi vueEnnemi;
    private SoldatEnnemie soldatEnnemie;
    private Environnement envi;
    @FXML
    private Pane affichagePane;
    @FXML
    private TilePane affichageTilePane;
    private VueItem potion;
    private Item item;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);
        this.map = new Map();
        this.envi = new Environnement();

        // Initialiser le personnage principal
        this.personnage = new Personnage("Lokmen", 100,10,10,new Hache(), envi);

        // Initialiser le soldat ennemi
        this.soldatEnnemie = new SoldatEnnemie("Ennemi", 60, 30, 30, null, envi, personnage);

        // Initialise les potions
        Item item = new Potion("popo1",envi);
        Item item1 = new Potion("popo2",envi);

        // Ajoute l'item a l'envi
        this.envi.ajouter(item);
        this.envi.ajouter(item1);

        //Initialiser le clavier
        Clavier clavier = new Clavier(personnage, affichagePane, affichageTilePane, map, item);

        // Initialiser les vues
        this.vueMap = new VueMap(affichageTilePane, map);
        this.vueLink = new VueLink(affichagePane, personnage, affichageTilePane, clavier);
        this.vueEnnemi = new VueEnnemi(affichagePane, affichageTilePane, soldatEnnemie);
        this.potion = new VueItem(affichagePane,item);

        clavier.setVueLink(vueLink);

        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, clavier);

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
                        System.out.println("un tour");
                        soldatEnnemie.suivreJoueur2();
                    }
                    temps++;
                })
        );

        gameLoop.getKeyFrames().add(keyFrame);

    }
}
