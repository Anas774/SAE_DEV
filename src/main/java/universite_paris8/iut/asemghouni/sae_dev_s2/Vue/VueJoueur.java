package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class VueJoueur {
private Personnage ennemi ;
    public VueJoueur(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        this.ennemi=new Personnage();
        creeSprite(affichagePane, personnage, tilePane);
        creerEnnemi(affichagePane,ennemi,tilePane);
    }

    private void creeSprite(Pane affichagePane, Personnage personnage, TilePane tilePane) {
        Circle circle = new Circle(10);
        circle.setFill(Color.BLACK);
        circle.setId("#" + personnage.getId());
        Clavier x = new Clavier(personnage, affichagePane, tilePane,new Map());
        affichagePane.addEventFilter(KeyEvent.KEY_PRESSED, x);
        circle.translateXProperty().bind(personnage.getXProperty());
        circle.translateYProperty().bind(personnage.getYProperty());
        affichagePane.getChildren().add(circle);
    }


    /*créa d'ennemie se déplaçant seul*/

    private void creerEnnemi(Pane affichagePane, Personnage perso, TilePane tilePane) {
        Circle ennemiCircle = new Circle(15);
        ennemiCircle.setFill(Color.RED);
        ennemiCircle.translateXProperty().bind(perso.getXProperty());
        ennemiCircle.translateYProperty().bind(perso.getYProperty());
        affichagePane.getChildren().add(ennemiCircle);
    }

    public Personnage getEnnemi() {
        return ennemi;
    }



}