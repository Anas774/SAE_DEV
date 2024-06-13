package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.DirectionalLight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.SoldatEnnemie;

public class VueVieEnnemi {

    private IntegerProperty pointVie;
    private Image coeurPlein;
    private Image coeurVide;
    private HBox healthBox;
    private SoldatEnnemie soldatEnnemie;

    public VueVieEnnemi(IntegerProperty pointVie, SoldatEnnemie soldatEnnemie, Pane affichagePane) {
        this.pointVie = pointVie;
        this.coeurPlein = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_full.png"));
        this.coeurVide = new Image(getClass().getResourceAsStream("/universite_paris8/iut/asemghouni/sae_dev_s2/imageVie/heart_blank.png"));
        this.healthBox = new HBox();
        affichagePane.getChildren().add(healthBox);
        this.soldatEnnemie = soldatEnnemie;
        healthBox.setSpacing(2);
        initialiserBarreVie();
        ajouterListeners();
        ajusterPositionCoeurs();
        mettreAJourBarreVie();
    }

    private void initialiserBarreVie() {
        for (int i = 0; i < 10; i++) {
            ImageView imageViewVie = new ImageView(coeurVide);
            imageViewVie.setFitWidth(10);
            imageViewVie.setFitHeight(10);
            healthBox.getChildren().add(imageViewVie);
        }
    }

    private void ajouterListeners() {
        this.pointVie.addListener((obs, old, nouv) -> mettreAJourBarreVie());
        this.soldatEnnemie.getXProperty().addListener((obs, oldX, newX) -> ajusterPositionCoeurs());
        this.soldatEnnemie.getYProperty().addListener((obs, oldY, newY) -> ajusterPositionCoeurs());
    }

    private void mettreAJourBarreVie() {
        int vieActuelle = pointVie.get();

        for (int i = 0; i < healthBox.getChildren().size(); i++) {
            ImageView coeur = (ImageView) healthBox.getChildren().get(i);
            if (i < vieActuelle) {
                coeur.setImage(coeurPlein);
            } else {
                coeur.setImage(coeurVide);
            }
        }
    }

    private void ajusterPositionCoeurs() {

        double ennemiX = soldatEnnemie.getX();
        double ennemiY = soldatEnnemie.getY();

        healthBox.setLayoutX(ennemiX - 45);
        healthBox.setLayoutY(ennemiY - 10);
    }

    public HBox getHealthBox() {
        return healthBox;
    }
}
