package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Observateur;

import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.MasterSword;

import java.util.ArrayList;

public class ObservateurArme implements ListChangeListener<Arme> {

    private Pane affichage;
    private ArrayList<Arme> vueArme;

    public ObservateurArme(Pane affichage) {
        this.affichage = affichage;
        this.vueArme = new ArrayList<>();
    }

    @Override
    public void onChanged(Change<? extends Arme> change) {
        while (change.next()) {

            if (change.wasAdded()) {

                for (Arme arme : change.getAddedSubList()) {
                    if (arme instanceof MasterSword) {
                        creeMasterSword(affichage, arme);
                    }
                }

            } else if (change.wasRemoved()) {
                for (Arme arme : change.getRemoved()) {
                    this.affichage.getChildren().remove(affichage.lookup("#" + arme.getId()));
                }
            }
        }
    }

    private void creeMasterSword(Pane affichagePane, Arme arme) {
        Image item1 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/sword_normal.png").toString());
        ImageView armeImageview = new ImageView(item1);
        armeImageview.setFitWidth(18);
        armeImageview.setFitHeight(18);
        armeImageview.setId(arme.getId());
        armeImageview.translateXProperty().bind(arme.getXProperty());
        armeImageview.translateYProperty().bind(arme.getYProperty());
        affichagePane.getChildren().add(armeImageview);
    }
}
