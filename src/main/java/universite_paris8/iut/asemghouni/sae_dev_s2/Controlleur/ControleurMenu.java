package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import universite_paris8.iut.asemghouni.sae_dev_s2.HelloApplication;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurMenu implements Initializable {
    @FXML
    ImageView imageFond;
    @FXML
    VBox contenueBoutons;
    @FXML
    VBox contenuRegles;
    @FXML
    VBox contenuCredits;
    @FXML
    VBox contenuCommandes;
    @FXML
    VBox contenuQuitter;
    @FXML
    Button boutonQuitter;


    @FXML
    public void gererBoutonJouer(ActionEvent event) throws IOException {
        System.out.println("Lancement du jeu");
        try {
            HelloApplication main = new HelloApplication();
            main.start(new Stage());
            Scene scene = ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).getScene();
            Stage stage = new Stage();
            stage.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void gererBoutonRegles(ActionEvent event){
        System.out.println("Affichage des règles");
        cacherLeContenu();
        contenueBoutons.setVisible(false);
        contenuRegles.setVisible(true);
    }

    @FXML
    public void gererBoutonCommandes(ActionEvent event){
        System.out.println("Affichage des commandes");
        cacherLeContenu();
        contenueBoutons.setVisible(false);
        contenuCommandes.setVisible(true);
    }

    @FXML
    public void gererBoutonCredits(ActionEvent event){
        System.out.println("Affichage des crédits en cours");
        cacherLeContenu();
        contenueBoutons.setVisible(false);
        contenuCredits.setVisible(true);
    }
    @FXML
    public void gererBoutonQuitter(ActionEvent event){
        System.out.println(" ");
        cacherLeContenu();
        contenueBoutons.setVisible(false);
        boutonQuitter.setVisible(false);
        contenuQuitter.setVisible(true);
    }

    @FXML
    private void retourAuMenu(ActionEvent event){
        cacherLeContenu();
    }
    @FXML
    private void confirmerQuitter(){
        System.out.println("Vous avez choisi de quitter");
        System.exit(0);
    }
    @FXML
    private void annulerQuitter() {
        System.out.println("Fermeture de la fenêtre");
        cacherLeContenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void cacherLeContenu() {
        contenueBoutons.setVisible(true);
        contenuRegles.setVisible(false);
        contenuCredits.setVisible(false);
        contenuQuitter.setVisible(false);
        contenuCommandes.setVisible(false);
        boutonQuitter.setVisible(true);
    }
}
