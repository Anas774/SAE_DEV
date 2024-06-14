package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;

public class VueMap {
    private static final int TAILLE_TUILE = 38;

    public VueMap(TilePane tilePane, Map mapJeu) {
        // Configurer le nombre de colonnes du TilePane
        tilePane.setPrefTileWidth(TAILLE_TUILE);
        tilePane.setPrefTileHeight(TAILLE_TUILE);
        tilePane.setPrefColumns(mapJeu.getLargeur());
        creerMap(tilePane, mapJeu);
    }

    public void creerMap(TilePane tilePane, Map mapJeu) {
        Image sol = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/sol.png").toString());
        Image bordHaut = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/haut.png").toString());
        Image collision = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/fond.png").toString());
        Image bordGauche = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/gauche.png").toString());
        Image bordBas = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/bas.png").toString());
        Image bordDroit = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/droite.png").toString());


        tilePane.getChildren().clear(); // Vider le TilePane avant de remplir

        for (int i = 0; i < mapJeu.getMapJeu().length; i++) {
            ImageView vue = new ImageView();
            vue.setFitWidth(TAILLE_TUILE);
            vue.setFitHeight(TAILLE_TUILE);

            if (mapJeu.getMapJeu()[i] == 1) {
                vue.setImage(sol);
            } else if (mapJeu.getMapJeu()[i] == 2) {
                vue.setImage(collision);
            }
            else if (mapJeu.getMapJeu()[i] == 3) {
                vue.setImage(bordHaut);
            }
            else if (mapJeu.getMapJeu()[i] == 4) {
                vue.setImage(bordGauche);
            }
            else if (mapJeu.getMapJeu()[i] == 5) {
                vue.setImage(bordBas);
            }
            else if (mapJeu.getMapJeu()[i] == 6) {
                vue.setImage(bordDroit);
            }


            else {
                vue.setImage(sol);
            }

            tilePane.getChildren().add(vue);
        }
    }
}
