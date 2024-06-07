package universite_paris8.iut.asemghouni.sae_dev_s2.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Item;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

public class VueItem {

    private Item item;
    private ImageView itemImageView;
    private Image itemImage;
    private Personnage personnage;

    public VueItem(Pane affichagePane, Item item, TilePane tilePane, Personnage personnage) {
        this.item = item;
        this.personnage = personnage;
        creeItem(affichagePane, item, tilePane);
    }

    private void creeItem(Pane affichagePane, Item item, TilePane tilePane) {
        itemImage = new Image(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/image/potion_bleu.png").toString());
        itemImageView = new ImageView(itemImage);
        itemImageView.setFitWidth(15);
        itemImageView.setFitHeight(15);
        itemImageView.setId("#" + item.getId());
        itemImageView.translateXProperty().bind(item.getXProperty());
        itemImageView.translateYProperty().bind(item.getYProperty());
        affichagePane.getChildren().add(itemImageView);

        if(personnage.getX()==item.getX()&&personnage.getY()==item.getY() && personnage.getXProperty()==item.getXProperty()&& personnage.getYProperty()==item.getYProperty()){
            affichagePane.getChildren().remove(itemImageView);
        }
    }

}
