package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
//import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueItem;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueLink;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Epée;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Link;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;
import java.util.List;

public class Clavier implements EventHandler<KeyEvent> {

    private Link personnage;
    private Pane affichagePane;
    private TilePane tilePane;
    private Map map;
    private VueLink vueLink;
    private Item item;

    public Clavier(Link personnage, Pane affichagePane, TilePane tilePane, Map map, Item item) {
        this.personnage = personnage;
        this.affichagePane = affichagePane;
        this.tilePane = tilePane;
        this.map = map;
        this.item = item;
    }

    public void setVueLink(VueLink vueLink) {
        this.vueLink = vueLink;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public void handle(KeyEvent event) {

        System.out.println("Touche pressée : " + event.getCode() + "\n");

        int PosTuileX = personnage.getX() / 38;
        int PosTuileY = personnage.getY() / 38;

        int newX = personnage.getX();
        int newY = personnage.getY();

        if (personnage.estVivant()) {

            switch (event.getCode()) {

                case Z -> {
                    newY -= personnage.getVitesse();
                    vueLink.setdirection("up");
                }
                case S -> {
                    newY += personnage.getVitesse();
                    vueLink.setdirection("down");
                }
                case Q -> {
                    newX -= personnage.getVitesse();
                    vueLink.setdirection("left");
                }
                case D -> {
                    newX += personnage.getVitesse();
                    vueLink.setdirection("right");
                }

            }

            if (!personnage.detectCollision(newX, newY)) {
                personnage.setX(newX);
                personnage.setY(newY);

            } else {
                System.out.println("\n" + "Limite OU Mur !!!" + "\n");
            }
        }

        System.out.println("Position du perso en pixels : " + personnage.getX() + " px" + " | " + personnage.getY() + " px");
        System.out.println("Position du perso en case X : " + PosTuileX + "    | case Y : " + PosTuileY + "\n");

    }
}