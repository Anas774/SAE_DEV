package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueLink;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueMap;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Personnage personnage;
    private Map map;
    private VueMap vueMap;
    private VueLink vueLink;
    @FXML
    private Pane affichagePane;
    @FXML
    private TilePane affichageTilePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        affichageTilePane.setPrefTileHeight(38);
        affichageTilePane.setPrefTileWidth(38);
        this.map = new Map();
        this.personnage = new Personnage();
        this.vueMap = new VueMap(affichageTilePane, map);

        Clavier clavier = new Clavier(personnage, affichagePane, affichageTilePane, map);
        this.vueLink = new VueLink(affichagePane, personnage, affichageTilePane, clavier);
        clavier.setVueLink(vueLink);

        affichagePane.requestFocus();
        affichagePane.addEventHandler(KeyEvent.KEY_PRESSED, clavier);
    }

    @FXML
    public void mouseClicked(MouseEvent mouseEvent) {
        affichagePane.requestFocus();
    }
}
