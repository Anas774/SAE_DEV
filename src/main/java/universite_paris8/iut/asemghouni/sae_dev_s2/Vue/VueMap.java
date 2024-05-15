package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;

public class VueMap {
    public VueMap(TilePane tilePane, Map mapJeu) {
        creerMap(tilePane, mapJeu);
    }

    private void creerMap(TilePane tilePane, Map mapJeu) {
        double tileHauteur = tilePane.getPrefTileHeight();
        double tileLargeur = tilePane.getPrefTileWidth();

        for (int i = 0; i < mapJeu.getMapJeu().length; i++) {
            Rectangle rectangle = new Rectangle(tileLargeur, tileHauteur);
            if (mapJeu.getMapJeu()[i] == 1) {
                rectangle.setFill(Color.GREEN);
            } else if (mapJeu.getMapJeu()[i] == 5) {
                rectangle.setFill(Color.BLUE);
            }
            else {
                rectangle.setFill(Color.RED);
            }
            tilePane.getChildren().add(rectangle);
        }
    }
}
