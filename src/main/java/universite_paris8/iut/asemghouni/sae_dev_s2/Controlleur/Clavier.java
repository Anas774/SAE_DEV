package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Vue.VueLink;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;
import java.util.List;

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

        int PosTuileX = personnage.getX() / 38;
        int PosTuileY = personnage.getY() / 38;

        int newX = personnage.getX();
        int newY = personnage.getY();

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

        if (!detectCollision(newX, newY)) {
            personnage.setX(newX);
            personnage.setY(newY);
        }
        else {
            System.out.println("Limite OU Mur !!!");
        }
        System.out.println("Position du perso : " + personnage.getX() + ", " + personnage.getY());
        System.out.println(PosTuileX + ", " + PosTuileY);
    }

    public boolean detectCollision(int newX, int newY) {
        List<int[]> coins = personnage.getCoins(newX, newY);
        for (int[] coin : coins) {
            if (map.estMur(coin[0], coin[1]) || map.estLimite(coin[0], coin[1])) {
                return true;
            }
        }
        return false;
    }




}