    package universite_paris8.iut.asemghouni.sae_dev_s2;

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.stage.Stage;

    import java.io.IOException;

    public class HelloApplication extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MapSAE.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1224, 720);
            stage.setTitle("Hello");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }