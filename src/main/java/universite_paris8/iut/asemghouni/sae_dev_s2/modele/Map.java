package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class Map {
        private int[] mapJeu;
        private int hauteur;
        private int largeur;

        public Map() {
            this.hauteur = 10;
            this.largeur = 10;
            this.mapJeu = new int[]{
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 5, 0, 0, 0, 0, 0, 0, 0, 1,
                    1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                    1, 0, 0, 0, 0, 5, 0, 5, 0, 1,
                    1, 0, 0, 0, 0, 0, 0, 5, 0, 1,
                    1, 0, 0, 0, 5, 0, 0, 5, 0, 1,
                    1, 0, 0, 5, 0, 0, 0, 0, 0, 1,
                    1, 0, 0, 0, 0, 0, 5, 0, 0, 1,
                    1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1
            };
        }

        public int getHauteur() {
            return hauteur;
        }

        public int getLargeur() {
            return largeur;
        }

        public boolean estLimite(int x, int y) {
            return x < 0 || x >= largeur * 38 || y < 0 || y >= hauteur * 38;
        }

        public boolean estMur(int x, int y) {

            int PosTuileX = x / 38;
            int PosTuileY = y / 38;

            if (estLimite(x,y)) {
                return false;
            }
            return mapJeu[PosTuileY * largeur + PosTuileX] == 5;
        }

        public int[] getMapJeu() {
            return mapJeu;
        }
}



