package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueLink;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class Clavier implements EventHandler<KeyEvent> {

    private Personnage personnage;
    private Pane affichagePane;
    private TilePane tilePane;
    private Map map;
    private VueLink vueLink;

    public Clavier(Personnage personnage, Pane affichagePane, TilePane tilePane, Map map) {
        this.personnage = personnage;
        this.affichagePane = affichagePane;
        this.tilePane = tilePane;
        this.map = map;
    }

    public void setVueLink(VueLink vueLink) {
        this.vueLink = vueLink;
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println("Touche pressée : " + event.getCode());

        int oldX = personnage.getX();
        int oldY = personnage.getY();

        int newX = oldX;
        int newY = oldY;

        double largeurTile = tilePane.getPrefTileWidth();
        double hauteurTile = tilePane.getPrefTileHeight();

        switch (event.getCode()) {
            case Z -> {
                newY -= personnage.getVitesse();
                vueLink.direction("up");
            }
            case S -> {
                newY += personnage.getVitesse();
                vueLink.direction("down");
            }
            case Q -> {
                newX -= personnage.getVitesse();
                vueLink.direction("left");
            }
            case D -> {
                newX += personnage.getVitesse();
                vueLink.direction("right");
            }
        }

        int coordX = newX / (int) largeurTile;
        int coordY = newY / (int) hauteurTile;

        if (!map.estMur(coordX, coordY)) {

            if (newX >= 0 && newX < 360) {
                personnage.setX(newX);
            } else {
                System.out.println("Vous avez atteint la limite du terrain");
            }
            if (newY >= 0 && newY < 360) {
                personnage.setY(newY);
            } else {
                System.out.println("Vous avez atteint la limite du terrain");
            }
            System.out.println("Position : " + personnage.getX() + ", " + personnage.getY());
        } else {
            System.out.println("Il y a un mur");
        }
    }
}
