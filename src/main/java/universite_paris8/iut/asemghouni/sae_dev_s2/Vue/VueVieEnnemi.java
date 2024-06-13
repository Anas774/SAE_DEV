package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.SoldatEnnemi;

public class VueVieEnnemi {

    private Personnage personnage;
    private Rectangle premiereCouche;
    private Rectangle deuxiemeCouche;

    public VueVieEnnemi(IntegerProperty pointVie, SoldatEnnemi soldatEnnemi, Pane affichagePane) {
        this.personnage = soldatEnnemi;

        // Création des rectangles pour la barre de vie
        creerBarreVie(affichagePane);

        // Initialisation de la barre de vie avec les valeurs initiales
        mettreAJourCouleurBarreDeVie();

        // Ajout d'un écouteur sur les points de vie pour mettre à jour la barre de vie
        pointVie.addListener((obs, oldValue, newValue) -> {
            mettreAJourCouleurBarreDeVie();
        });
    }

    private void creerBarreVie(Pane affichagePane) {
        premiereCouche = new Rectangle();
        premiereCouche.setFill(Color.GREY);
        premiereCouche.setWidth((personnage.getPointVie().get() + 10)); // Ajuster la largeur initiale si nécessaire
        premiereCouche.setHeight(10); // Hauteur de la première couche
        premiereCouche.setId("Background" + personnage.getId());
        premiereCouche.setArcWidth(10);
        premiereCouche.setArcHeight(10);
        affichagePane.getChildren().add(premiereCouche);

        deuxiemeCouche = new Rectangle();
        deuxiemeCouche.setFill(Color.GREEN);
        deuxiemeCouche.setWidth((personnage.getPointVie().get() + 10)); // Ajuster la largeur initiale si nécessaire
        deuxiemeCouche.setHeight(10); // Hauteur de la deuxième couche
        deuxiemeCouche.setId("Vie" + personnage.getId());
        deuxiemeCouche.setArcHeight(10);
        deuxiemeCouche.setArcWidth(10);
        affichagePane.getChildren().add(deuxiemeCouche);

        // Binding des positions des rectangles aux propriétés de position du personnage
        premiereCouche.translateXProperty().bind(personnage.getXProperty().add((38 - premiereCouche.getWidth()) / 2));
        premiereCouche.translateYProperty().bind(personnage.getYProperty().add(((38 - premiereCouche.getHeight()) / 2 - 5) - 38 / 2));
        deuxiemeCouche.translateXProperty().bind(personnage.getXProperty().add((38 - deuxiemeCouche.getWidth()) / 2));
        deuxiemeCouche.translateYProperty().bind(personnage.getYProperty().add(((38 - deuxiemeCouche.getHeight()) / 2 - 5) - 38 / 2));

        // Binding de la largeur de la deuxième couche aux points de vie du personnage
        deuxiemeCouche.widthProperty().bind(personnage.getPointVie().divide(2));
    }

    private void mettreAJourCouleurBarreDeVie() {
        double largeurActuelle = deuxiemeCouche.getWidth();
        double largeurMaximale = premiereCouche.getWidth() - 5;

        if (largeurActuelle >= largeurMaximale * 0.9) {
            deuxiemeCouche.setFill(Color.GREEN);
        } else if (largeurActuelle >= largeurMaximale * 0.7) {
            deuxiemeCouche.setFill(Color.YELLOWGREEN);
        } else if (largeurActuelle >= largeurMaximale * 0.5) {
            deuxiemeCouche.setFill(Color.ORANGERED);
        } else if (largeurActuelle < largeurMaximale * 0.35) {
            deuxiemeCouche.setFill(Color.RED);
        }
    }

}
