package universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlleurMenu {

    private Stage stage;
    @FXML
    private ImageView imageFond;
    @FXML
    private VBox contenueBoutons;
    @FXML
    private VBox contenuRegles;
    @FXML
    private VBox contenuCredits;
    @FXML
    private VBox contenuCommandes;
    @FXML
    private VBox contenuQuitter;
    @FXML
    private Button boutonQuitter;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void gererBoutonJouer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/MapSAE.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Le Chevalier d'Hyrule");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void gererBoutonRegles() {
        System.out.println("Affichage des règles");
        cacherLeContenu();
        contenueBoutons.setVisible(false);
        contenuRegles.setVisible(true);
    }

    @FXML
    private void gererBoutonCommandes() {
        System.out.println("Affichage des commandes");
        cacherLeContenu();
        contenueBoutons.setVisible(false);
        contenuCommandes.setVisible(true);
    }

    @FXML
    private void gererBoutonCredits() {
        System.out.println("Affichage des crédits en cours");
        cacherLeContenu();
        contenueBoutons.setVisible(false);
        contenuCredits.setVisible(true);
    }

    @FXML
    private void gererBoutonQuitter() {
        System.out.println(" ");
        cacherLeContenu();
        contenueBoutons.setVisible(false);
        boutonQuitter.setVisible(false);
        contenuQuitter.setVisible(true);
    }

    @FXML
    private void retourAuMenu() {
        cacherLeContenu();
    }

    @FXML
    private void confirmerQuitter() {
        System.out.println("Vous avez choisi de quitter");
        System.exit(0);
    }

    @FXML
    private void annulerQuitter() {
        System.out.println("Fermeture de la fenêtre");
        cacherLeContenu();
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

