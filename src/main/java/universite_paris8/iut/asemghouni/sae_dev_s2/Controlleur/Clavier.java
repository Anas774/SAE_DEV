package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class Clavier implements EventHandler<KeyEvent> {

    private Personnage personnage;


    public Clavier(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case Z -> personnage.setY(personnage.getY() - 10);
            case S -> personnage.setY(personnage.getY() + 10);
            case Q -> personnage.setX(personnage.getX() - 10);
            case D -> personnage.setX(personnage.getX() + 10);
        }
        System.out.println("Position : " + personnage.getX() + ", " + personnage.getY());

//        if (personnage.getX() > 0 && personnage.getX() <= maxX && personnage.getY() > 0 && personnage.getY() <= maxY) {
//            personnage.setX(personnage.getX());
//            personnage.setY(personnage.getY());
        }

}
