package universite_paris8.iut.asemghouni.sae_dev_s2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur.ControlleurMenu;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/universite_paris8/iut/asemghouni/sae_dev_s2/GameMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 845, 667);
        stage.setTitle("Le Chevalier d'Hyrule");
        stage.setScene(scene);

        // Obtenez le contrôleur et passez-lui le stage
        ControlleurMenu controllerMenu = fxmlLoader.getController();
        controllerMenu.setStage(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}