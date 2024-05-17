package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class Clavier implements EventHandler<KeyEvent> {

    private Personnage personnage;
    private Pane affichagePane;
    public boolean pressH, pressB, pressG, pressD;

    public Clavier(Personnage personnage, Pane affichagePane) {
        this.personnage = personnage;
        this.affichagePane = affichagePane;
    }

    @Override
    public void handle(KeyEvent event) {

        double maxX = affichagePane.getWidth();
        double maxY = affichagePane.getHeight();

        System.out.println("Touche presse : " + event.getCode());

        double newX = personnage.getX();
        double newY = personnage.getY();

        switch (event.getCode()) {
            case Z -> {
                if (newY >= 0 && newY <= maxY) {
                    personnage.setY(personnage.getY() - personnage.getVitesse());
                    pressH=true;
                }
            }
            case S -> {
                if (newY >= 0 && newY <= maxY) {
                    personnage.setY(personnage.getY() + personnage.getVitesse());
                    pressB=true;
                }
            }
            case Q -> {
                if (newX >= 0 && newX <= maxX) {
                    personnage.setX(personnage.getX() - personnage.getVitesse());
                    pressG=true;
                }
            }
            case D -> {
                if (newX >= 0 && newX <= maxX) {
                    personnage.setX(personnage.getX() + personnage.getVitesse());
                    pressD=true;
                }
            }
        }
        System.out.println("Position : " + personnage.getX() + ", " + personnage.getY());

//        if (newX >= 0 && newX <= maxX && newY >= 0 && newY <= maxY) {
//            personnage.setX(personnage.getX());
//            personnage.setY(personnage.getY());
//        }

    }

}