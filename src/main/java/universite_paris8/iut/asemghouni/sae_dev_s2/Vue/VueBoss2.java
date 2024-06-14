package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Boss;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Boss2;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.SoldatEnnemi;

public class VueBoss2 {
    private Boss2 boss2;
    private ImageView boss2ImageView;
    private Rectangle premiereCouche;
    private Rectangle deuxiemeCouche;
    private Link link;

    public VueBoss2(Pane affichagePane, TilePane tilePane, Boss2 boss2, Link link) {
        this.boss2 = boss2;
        this.link = link;
        creerBoss2(affichagePane, tilePane, boss2);
        creerBarreVie(affichagePane, boss2);
    }

    private void creerBoss2(Pane affichagePane, TilePane tilePane, Boss2 boss2) {
        Image ennemi = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Ennemi/Boss2.png").toString());
        this.boss2ImageView = new ImageView(ennemi);
        boss2ImageView.setFitWidth(40);
        boss2ImageView.setFitHeight(40);
        boss2ImageView.setId("#" + boss2.getId());
        boss2ImageView.translateXProperty().bind(boss2.getXProperty());
        boss2ImageView.translateYProperty().bind(boss2.getYProperty());
        affichagePane.getChildren().add(boss2ImageView);

        // Ajouter l'événement onMouseClicked pour infliger des dégâts
        boss2ImageView.setOnMouseClicked(event -> {
            link.infligerDegats(boss2, 30);
            mettreAJourCouleurBarreDeVie();
        });
    }

    private void creerBarreVie(Pane affichagePane, Boss2 boss2) {
        premiereCouche = new Rectangle();
        premiereCouche.setFill(Color.GREY);
        premiereCouche.setWidth((boss2.getPointVie().get() / 2)); // Ajuster la largeur initiale si nécessaire
        premiereCouche.setHeight(10); // Hauteur de la première couche
        premiereCouche.setId("Background" + boss2.getId());
        premiereCouche.setArcWidth(10);
        premiereCouche.setArcHeight(10);
        affichagePane.getChildren().add(premiereCouche);

        deuxiemeCouche = new Rectangle();
        deuxiemeCouche.setFill(Color.GREEN);
        deuxiemeCouche.setWidth((boss2.getPointVie().get() / 2)); // Ajuster la largeur initiale si nécessaire
        deuxiemeCouche.setHeight(10); // Hauteur de la deuxième couche
        deuxiemeCouche.setId("Vie" + boss2.getId());
        deuxiemeCouche.setArcHeight(10);
        deuxiemeCouche.setArcWidth(10);
        affichagePane.getChildren().add(deuxiemeCouche);

        // Binding des positions des rectangles aux propriétés de position du personnage
        premiereCouche.translateXProperty().bind(boss2.getXProperty().add((38 - premiereCouche.getWidth()) / 2));
        premiereCouche.translateYProperty().bind(boss2.getYProperty().add(((38 - premiereCouche.getHeight()) / 2 - 5) - 38 / 2));
        deuxiemeCouche.translateXProperty().bind(boss2.getXProperty().add((38 - deuxiemeCouche.getWidth()) / 2));
        deuxiemeCouche.translateYProperty().bind(boss2.getYProperty().add(((38 - deuxiemeCouche.getHeight()) / 2 - 5) - 38 / 2));

        // Binding de la largeur de la deuxième couche aux points de vie du personnage
        deuxiemeCouche.widthProperty().bind(boss2.getPointVie().divide(2));
    }

    private void mettreAJourCouleurBarreDeVie() {
        double largeurActuelle = deuxiemeCouche.getWidth();
        double largeurMaximale = premiereCouche.getWidth() - 5;

        if (largeurActuelle >= largeurMaximale * 0.75) {
            deuxiemeCouche.setFill(Color.GREEN);
        } else if (largeurActuelle >= largeurMaximale * 0.5) {
            deuxiemeCouche.setFill(Color.YELLOWGREEN);
        } else if (largeurActuelle >= largeurMaximale * 0.25) {
            deuxiemeCouche.setFill(Color.ORANGERED);
        } else {
            deuxiemeCouche.setFill(Color.RED);
        }
    }

    public void supprimerVue(Pane affichagePane) {
        affichagePane.getChildren().remove(boss2ImageView);
        affichagePane.getChildren().remove(premiereCouche);
        affichagePane.getChildren().remove(deuxiemeCouche);
    }
}
