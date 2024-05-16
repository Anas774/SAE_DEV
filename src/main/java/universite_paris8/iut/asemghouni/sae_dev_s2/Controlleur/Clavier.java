package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class Clavier implements EventHandler<KeyEvent> {

    private Personnage personnage;
    private Pane affichagePane;
    private TilePane affichageTilePane;

    public Clavier(Personnage personnage, Pane affichagePane, TilePane affichageTilePane) {
        this.personnage = personnage;
        this.affichagePane = affichagePane;
        this.affichageTilePane = affichageTilePane;
    }

    @Override
    public void handle(KeyEvent event) {

        System.out.println("Touche presse : " + event.getCode());

        int newX = personnage.getX();
        int newY = personnage.getY();

        switch (event.getCode()) {
            case Z -> newY -= personnage.getVitesse();

            case S -> newY += personnage.getVitesse();

            case Q -> newX -= personnage.getVitesse();

            case D -> newX += personnage.getVitesse();
        }

        if (newX >= 20 && newX < 370) {
            personnage.setX(newX);
        }
        else {
            System.out.println("Vous avez atteint la limite du terrain");
        }
        if (newY >= 20 && newY < 370) {
            personnage.setY(newY);
        }
        else {
            System.out.println("Vous avez atteint la limite du terrain");
        }

        System.out.println("Position : " + personnage.getX() + ", " + personnage.getY());





//        if (newX >= 0 && newX <= maxX && newY >= 0 && newY <= maxY) {
//            personnage.setX(personnage.getX());
//            personnage.setY(personnage.getY());
//        }

    }

}
