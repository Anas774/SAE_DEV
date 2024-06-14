package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Boss;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.SoldatEnnemi;

public class VueBoss {
    private Boss boss;
    private ImageView bossImageView;
    private Rectangle premiereCouche;
    private Rectangle deuxiemeCouche;
    private Link link;

    public VueBoss(Pane affichagePane, TilePane tilePane, Boss boss, Link link) {
        this.boss = boss;
        this.link = link;
        creerBoss(affichagePane, tilePane, boss);
        creerBarreVie(affichagePane, boss);
    }

    private void creerBoss(Pane affichagePane, TilePane tilePane, Boss boss) {
        Image ennemi = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Ennemi/Boss.png").toString());
        this.bossImageView = new ImageView(ennemi);
        bossImageView.setFitWidth(40);
        bossImageView.setFitHeight(40);
        bossImageView.setId("#" + boss.getId());
        bossImageView.translateXProperty().bind(boss.getXProperty());
        bossImageView.translateYProperty().bind(boss.getYProperty());
        affichagePane.getChildren().add(bossImageView);

        // Ajouter l'événement onMouseClicked pour infliger des dégâts
        bossImageView.setOnMouseClicked(event -> {
            link.infligerDegats(boss, 30);
            mettreAJourCouleurBarreDeVie();
        });
    }

    private void creerBarreVie(Pane affichagePane, Boss boss) {
        premiereCouche = new Rectangle();
        premiereCouche.setFill(Color.GREY);
        premiereCouche.setWidth((boss.getPointVie().get() / 2)); // Ajuster la largeur initiale si nécessaire
        premiereCouche.setHeight(10); // Hauteur de la première couche
        premiereCouche.setId("Background" + boss.getId());
        premiereCouche.setArcWidth(10);
        premiereCouche.setArcHeight(10);
        affichagePane.getChildren().add(premiereCouche);

        deuxiemeCouche = new Rectangle();
        deuxiemeCouche.setFill(Color.GREEN);
        deuxiemeCouche.setWidth((boss.getPointVie().get() / 2)); // Ajuster la largeur initiale si nécessaire
        deuxiemeCouche.setHeight(10); // Hauteur de la deuxième couche
        deuxiemeCouche.setId("Vie" + boss.getId());
        deuxiemeCouche.setArcHeight(10);
        deuxiemeCouche.setArcWidth(10);
        affichagePane.getChildren().add(deuxiemeCouche);

        // Binding des positions des rectangles aux propriétés de position du personnage
        premiereCouche.translateXProperty().bind(boss.getXProperty().add((38 - premiereCouche.getWidth()) / 2));
        premiereCouche.translateYProperty().bind(boss.getYProperty().add(((38 - premiereCouche.getHeight()) / 2 - 5) - 38 / 2));
        deuxiemeCouche.translateXProperty().bind(boss.getXProperty().add((38 - deuxiemeCouche.getWidth()) / 2));
        deuxiemeCouche.translateYProperty().bind(boss.getYProperty().add(((38 - deuxiemeCouche.getHeight()) / 2 - 5) - 38 / 2));

        // Binding de la largeur de la deuxième couche aux points de vie du personnage
        deuxiemeCouche.widthProperty().bind(boss.getPointVie().divide(2));
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
        affichagePane.getChildren().remove(bossImageView);
        affichagePane.getChildren().remove(premiereCouche);
        affichagePane.getChildren().remove(deuxiemeCouche);
    }
}
