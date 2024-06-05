package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.Clavier;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;

public class VueItem {

    private Item item;
    private ImageView itemImageview;
    private Clavier clavier;

    public VueItem(Pane affichagePane, Item item) {
        this.item = item;
        creeItem(affichagePane,item);
        faireApparaitreItemAléatoirement();
    }

    private void creeItem(Pane affichagePane, Item item) {
        Image item1 = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/potion_bleu.png").toString());
        this.itemImageview = new ImageView(item1);
        itemImageview.setFitWidth(15);
        itemImageview.setFitHeight(15);
        itemImageview.setId(item.getId());
        itemImageview.translateXProperty().bind(item.getXProperty());
        itemImageview.translateYProperty().bind(item.getYProperty());
        affichagePane.getChildren().add(itemImageview);
    }

    private void faireApparaitreItemAléatoirement() {

        int x,y;

        do {
            x = (int) (Math.random() * item.getEnvi().getMap().getHauteur() * 38);
            y = (int) (Math.random() * item.getEnvi().getMap().getLargeur() * 38);

        } while (item.getEnvi().getMap().estMur(x,y) || item.getEnvi().getMap().estLimite(x,y));

        item.apparitionItem(x,y);
    }

}