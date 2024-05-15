package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

public class Map {

    private int[] mapJeu;
    public Map() {
        this.mapJeu = new int[]{
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 0, 0, 0, 5, 0, 0, 5, 0, 1,
                1, 0, 0, 0, 5, 0, 0, 5, 0, 1,
                1, 0, 0, 5, 5, 0, 0, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 5, 0, 0, 1,
                1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

    }

    public int[] getMapJeu() {
        return this.mapJeu;
    }
}
