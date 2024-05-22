package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Hitbox {

    private IntegerProperty x;
    private IntegerProperty y;
    private int hauteur;
    private int largeur;

    public Hitbox(int x, int y, int largeur, int hauteur) {
        this.x = new SimpleIntegerProperty(20);
        this.y = new SimpleIntegerProperty(20);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public int getX() {
        return x.get();
    }
    public void setX(int x) {
        this.x.set(x);
    }

    public IntegerProperty xProperty() {
        return x;
    }
    public int getY() {
        return y.get();
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public boolean chevauchement(Hitbox autre) {

        boolean chevauchementGaucheDroite = this.getX() < autre.getX() + autre.getLargeur();
        boolean chevauchementDroiteGauche =  this.getX() + this.getLargeur() > autre.getX();
        boolean chevauchementHautBas = this.getY() < autre.getY() + autre.getHauteur();
        boolean chevauchementBasHaut = this.getY() + this.getHauteur() > autre.getY();

        return chevauchementGaucheDroite && chevauchementDroiteGauche && chevauchementHautBas && chevauchementBasHaut;
    }

}
