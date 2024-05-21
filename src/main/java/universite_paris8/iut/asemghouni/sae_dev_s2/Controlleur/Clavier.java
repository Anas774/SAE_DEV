package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Map;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class Clavier implements EventHandler<KeyEvent> {

    private Personnage personnage;
    private Pane affichagePane;
    private TilePane affichageTilePane;
    private Map map;

    public Clavier(Personnage personnage, Pane affichagePane, TilePane affichageTilePane, Map map) {
        this.personnage = personnage;
        this.affichagePane = affichagePane;
        this.affichageTilePane = affichageTilePane;
        this.map = map;
    }

    @Override
    public void handle(KeyEvent event) {

        System.out.println("Touche presse : " + event.getCode());

        int oldX = personnage.getX();
        int oldY = personnage.getY();

        int newX = oldX;
        int newY = oldY;

        double largeurTile = affichageTilePane.getPrefTileWidth();
        double hauteurTile = affichageTilePane.getPrefTileHeight();

        switch (event.getCode()) {
            case Z -> newY -= personnage.getVitesse();

            case S -> newY += personnage.getVitesse();

            case Q -> newX -= personnage.getVitesse();

            case D -> newX += personnage.getVitesse();
        }

        int coordX = newX / (int) largeurTile;
        int coordY = newY / (int) hauteurTile;


        if (!map.estMur(coordX,coordY)) {

            if (newX >= 0 && newX < 360) {                     // Valeur d'avant (avec Circle) : newX = 20   newY = 370
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
        }
        else {
            System.out.println("Il y'a un mur");
        }

    }

    /*
    Si les coordonnées (x, y) sont
    dans les limites de la carte, la méthode vérifie si
    la position correspond à un mur dans le tableau mapJeu :
    y * largeur + x :
    calcule l'index unidimensionnel correspondant aux coordonnées (x, y) dans le tableau mapJeu.
    y * largeur :
    donne le décalage de ligne dans le tableau.
    + x : donne le décalage de colonne dans cette ligne.
    mapJeu[y * largeur + x] :
    accède à la valeur à cet index dans mapJeu.
    == 1 : vérifie si cette valeur est 1. Si oui, cela signifie qu'il y a un mur à
    cette position.
    Si mapJeu[y * largeur + x] est égal à 1, la méthode renvoie true (indiquant un mur). Sinon, elle renvoie false (indiquant qu'il n'y a pas de mur).
     */

}