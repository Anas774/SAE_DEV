package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VueVie extends HBox {

    private IntegerProperty pointVie;
    private Image coeurPlein;
    private Image coeurMoitie;
    private Image coeurVide;

    public VueVie(IntegerProperty pointVie) {

        this.pointVie = pointVie;
        this.coeurPlein = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_full.png"));
        this.coeurMoitie = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_half.png"));
        this.coeurVide = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_blank.png"));

        initialiserBarreVie();
        mettreAJourBarreVie();
    }

    private void creerCoeur(IntegerProperty pointVie) {
        this.coeurPlein = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_full.png"));
        this.coeurMoitie = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_half.png"));
        this.coeurVide = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_blank.png"));

    }

    private void initialiserBarreVie() {
        for (int i = 0; i < 4; i++) {
            ImageView imageViewVie = new ImageView(coeurVide);
            this.getChildren().add(imageViewVie);
        }
    }

    private void ajouterListeners() {
        this.pointVie.addListener((obs,old,nouv) -> mettreAJourBarreVie());
    }

    private void mettreAJourBarreVie() {

        int vieActuelle = pointVie.get();

        for (int i = 0; i < this.getChildren().size(); i++) {
            ImageView coeur =  (ImageView) this.getChildren().get(i);
            if (i < vieActuelle) {
                coeur.setImage(coeurPlein);
            }
            else {
                coeur.setImage(coeurVide);
            }
        }
    }

}
