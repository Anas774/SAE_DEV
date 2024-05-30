package universite_paris8.iut.asemghouni.sae_dev_s2.modele;

import javafx.collections.ObservableList;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage.Personnage;

public class Environnement {

    private Map map;
    private ObservableList<Personnage> personnage;

    public Environnement() {
        this.map = new Map();
//        this.personnage = FXCollections.observableArrayList();
    }

    public Map getMap() {
        return this.map;
    }

    public ObservableList<Personnage> getPersonnages() {
        return this.personnage;
    }

    public void ajouter(Personnage personnage) {
        this.personnage.add(personnage);
    }

}