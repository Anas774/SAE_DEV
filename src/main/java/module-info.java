module universite_paris8.iut.asemghouni.sae_dev_s2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens universite_paris8.iut.asemghouni.sae_dev_s2 to javafx.fxml;
    exports universite_paris8.iut.asemghouni.sae_dev_s2;
    exports universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur;
    opens universite_paris8.iut.asemghouni.sae_dev_s2.Controlleur to javafx.fxml;
}