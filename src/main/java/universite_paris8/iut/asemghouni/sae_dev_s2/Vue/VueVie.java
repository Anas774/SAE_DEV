package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VueVie {

    private IntegerProperty pointVie;
    private Image coeurPlein;
    private Image coeurVide;
    private Image coeurMoitie;
    private HBox vieBox;

    public VueVie(HBox vieBox, IntegerProperty pointVie) {
        this.pointVie = pointVie;
        this.coeurPlein = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_full.png"));
        this.coeurMoitie = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_half.png"));
        this.coeurVide = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_blank.png"));
        this.vieBox = vieBox;
        vieBox.setSpacing(10);
        initialiserBarreVie();
        ajouterListeners();
        mettreAJourBarreVie();
    }

    private void initialiserBarreVie() {
        for (int i = 0; i < 10; i++) {
            ImageView imageViewVie = new ImageView(coeurVide);
            imageViewVie.setFitWidth(20);
            imageViewVie.setFitHeight(20);
            vieBox.getChildren().add(imageViewVie);
        }
    }

    private void ajouterListeners() {
        this.pointVie.addListener((obs, old, nouv) -> mettreAJourBarreVie());
    }

    private void mettreAJourBarreVie() {

        int vieActuelle = pointVie.get();
        int nombreCoeursPlein = vieActuelle / 2;
        boolean demiCoeur = vieActuelle % 2 == 1;

        for (int i = 0; i < vieBox.getChildren().size(); i++) {
            ImageView coeur = (ImageView) vieBox.getChildren().get(i);
            if (i < nombreCoeursPlein) {
                coeur.setImage(coeurPlein);
            } else if (i == nombreCoeursPlein && demiCoeur) {
                coeur.setImage(coeurMoitie);
            } else {
                coeur.setImage(coeurVide);
            }
        }
    }
}
