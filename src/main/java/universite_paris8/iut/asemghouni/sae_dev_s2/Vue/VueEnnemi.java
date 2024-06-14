package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.SoldatEnnemi;

public class VueEnnemi {
    private SoldatEnnemi soldatEnnemi;
    private ImageView ennemiImageView;
    private Rectangle premiereCouche;
    private Rectangle deuxiemeCouche;
    private Link link;

    public VueEnnemi(Pane affichagePane, TilePane tilePane, SoldatEnnemi soldatEnnemi, Link link) {
        this.soldatEnnemi = soldatEnnemi;
        this.link = link;
        creerEnnemi(affichagePane, tilePane, soldatEnnemi);
        creerBarreVie(affichagePane, soldatEnnemi);
    }

    private void creerEnnemi(Pane affichagePane, TilePane tilePane, SoldatEnnemi soldatEnnemi) {
        Image ennemi = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/Link/ennemi.png").toString());
        this.ennemiImageView = new ImageView(ennemi);
        ennemiImageView.setFitWidth(25);
        ennemiImageView.setFitHeight(25);
        ennemiImageView.setId("#" + soldatEnnemi.getId());
        ennemiImageView.translateXProperty().bind(soldatEnnemi.getXProperty());
        ennemiImageView.translateYProperty().bind(soldatEnnemi.getYProperty());
        affichagePane.getChildren().add(ennemiImageView);

        // Ajouter l'événement onMouseClicked pour infliger des dégâts
        ennemiImageView.setOnMouseClicked(event -> {
            link.infligerDegats(soldatEnnemi, 30);
            mettreAJourCouleurBarreDeVie();
        });
    }

    private void creerBarreVie(Pane affichagePane, SoldatEnnemi soldatEnnemi) {
        premiereCouche = new Rectangle();
        premiereCouche.setFill(Color.GREY);
        premiereCouche.setWidth((soldatEnnemi.getPointVie().get() / 2)); // Ajuster la largeur initiale si nécessaire
        premiereCouche.setHeight(10); // Hauteur de la première couche
        premiereCouche.setId("Background" + soldatEnnemi.getId());
        premiereCouche.setArcWidth(10);
        premiereCouche.setArcHeight(10);
        affichagePane.getChildren().add(premiereCouche);

        deuxiemeCouche = new Rectangle();
        deuxiemeCouche.setFill(Color.GREEN);
        deuxiemeCouche.setWidth((soldatEnnemi.getPointVie().get() / 2)); // Ajuster la largeur initiale si nécessaire
        deuxiemeCouche.setHeight(10); // Hauteur de la deuxième couche
        deuxiemeCouche.setId("Vie" + soldatEnnemi.getId());
        deuxiemeCouche.setArcHeight(10);
        deuxiemeCouche.setArcWidth(10);
        affichagePane.getChildren().add(deuxiemeCouche);

        // Binding des positions des rectangles aux propriétés de position du personnage
        premiereCouche.translateXProperty().bind(soldatEnnemi.getXProperty().add((38 - premiereCouche.getWidth()) / 2));
        premiereCouche.translateYProperty().bind(soldatEnnemi.getYProperty().add(((38 - premiereCouche.getHeight()) / 2 - 5) - 38 / 2));
        deuxiemeCouche.translateXProperty().bind(soldatEnnemi.getXProperty().add((38 - deuxiemeCouche.getWidth()) / 2));
        deuxiemeCouche.translateYProperty().bind(soldatEnnemi.getYProperty().add(((38 - deuxiemeCouche.getHeight()) / 2 - 5) - 38 / 2));

        // Binding de la largeur de la deuxième couche aux points de vie du personnage
        deuxiemeCouche.widthProperty().bind(soldatEnnemi.getPointVie().divide(2));
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
        affichagePane.getChildren().remove(ennemiImageView);
        affichagePane.getChildren().remove(premiereCouche);
        affichagePane.getChildren().remove(deuxiemeCouche);
    }
}
