package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;

public class VueMap {
    private static final int TAILLE_TUILE = 38;

    public VueMap(TilePane tilePane, Map mapJeu) {
        creerMap(tilePane, mapJeu);
    }

    public void creerMap(TilePane tilePane, Map mapJeu) {

        Image herbe = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/herbe.png").toString());
        Image terre = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/terre.png").toString());
        Image mur = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/mur.jpeg").toString());

        for (int i = 0; i < mapJeu.getMapJeu().length; i++) {
            ImageView vue = new ImageView();
            vue.setFitWidth(TAILLE_TUILE);
            vue.setFitHeight(TAILLE_TUILE);

            if (mapJeu.getMapJeu()[i] == 1) {
                vue.setImage(herbe);
            } else if (mapJeu.getMapJeu()[i] == 5) {
                vue.setImage(mur);
            } else {
                vue.setImage(terre);
            }

            tilePane.getChildren().add(vue);
        }
    }
}