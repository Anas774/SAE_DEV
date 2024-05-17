package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Map {

    private int[] mapJeu;
    public int hauteur;
    public int largeur;

    public Map() {
        this.hauteur = 10;
        this.largeur = 10;
        this.mapJeu = new int[]{
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 5, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 0, 0, 0, 0, 5, 0, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 5, 0, 1,
                1, 0, 0, 0, 5, 0, 0, 5, 0, 1,
                1, 0, 0, 5, 0, 0, 0, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 5, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

    }

    public int[] getMapJeu() {
        return this.mapJeu;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public boolean estMur(int x, int y) {
        if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
            return true;
        }
        return mapJeu[y * largeur + x] == 5;
    }
}
