package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class VueVie {
    private static final int maxVie = 5;  // Nombre maximum de cœurs
    private int vieBase;
    private Pane pane;  // Points de vie actuels du personnage
    private static final int COEUR_TAILLE = 15; // Taille des images des cœurs
    private Image coeur, moitieCoeur, coeurVide;
    private ImageView[] vueCoeur;
    private HBox healthBar;

    public VueVie(TilePane tilePane, Personnage personnage, Pane parentPane) {
        this.vieBase = personnage.getPointVie();  // Initialiser avec les points de vie du personnage
        this.pane = new Pane();
        creerCoeur(tilePane, personnage, parentPane);
    }

    public void creerCoeur(TilePane tilePane, Personnage personnage, Pane pane) {
        // Charger les images de cœur
        coeur = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/coeur.png").toString());
        moitieCoeur = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/moitierCoeur.png").toString());
        coeurVide = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/coeurVide.png").toString());

        // Créer la barre de vie
        healthBar = new HBox();
        healthBar.setSpacing(5); // Espace entre les cœurs
        vueCoeur = new ImageView[maxVie];

        for (int i = 0; i < maxVie; i++) {
            vueCoeur[i] = new ImageView(coeur);
            vueCoeur[i].setFitWidth(COEUR_TAILLE);
            vueCoeur[i].setFitHeight(COEUR_TAILLE);
            healthBar.getChildren().add(vueCoeur[i]);
        }
        healthBar.setLayoutY(10); //espace entre les coeurs
        tilePane.getChildren().add(healthBar);
    }

    public void updateHealthBar() {
        int vieReste = vieBase;
        for (int i = 0; i < maxVie; i++) {
            if (vieReste >= 20) { // Chaque cœur représente 20 points de vie
                vueCoeur[i].setImage(coeur);
                vieReste -= 20;
            } else if (vieReste >= 10) { // Moitié de cœur pour 10-19 points de vie
                vueCoeur[i].setImage(moitieCoeur);
                vieReste -= 10;
            } else {
                vueCoeur[i].setImage(coeurVide);
            }
        }
    }

    public void viderUnCoeur() {
        if (vieBase > 0) {
            vieBase -= 20;
            if (vieBase < 0) vieBase = 0; // S'assurer que la vie ne descend pas en dessous de zéro
            updateHealthBar();
        }
    }

    /*méthode pour ajt des coeurs !!*/

    public void setVie(int vie) {
        this.vieBase = vie;
        updateHealthBar();
    }

    public int getVieBase() {
        return vieBase;
    }
}
