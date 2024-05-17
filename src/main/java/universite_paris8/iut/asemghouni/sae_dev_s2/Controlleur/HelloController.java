package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueJoueur;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueMap;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class HelloController implements Initializable {
    private Personnage personnage;
    private Map map;
    private VueMap vueMap;
    private VueJoueur vueJoueur;
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
        this.vueJoueur = new VueJoueur(affichagePane, personnage);
        Clavier x = new Clavier(personnage, affichagePane);
//        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, x);
    }
    public void mouseClicked(MouseEvent mouseEvent) {
        affichagePane.requestFocus();
    }
}