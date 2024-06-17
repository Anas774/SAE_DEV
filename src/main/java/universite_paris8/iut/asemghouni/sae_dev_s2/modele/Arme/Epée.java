package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme;

public class Epée extends Arme {
        public Epée() {
            super("Epee", 4);               // 2 coeurs
        }
        @Override
        public String toString() {
            return "Arme : " + super.toString() + " point d'attaque : " + getPointsAttaqueArme();
        }

}
