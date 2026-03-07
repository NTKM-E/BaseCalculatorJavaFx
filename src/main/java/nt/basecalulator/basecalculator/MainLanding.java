package nt.basecalulator.basecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainLanding extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainLanding.class.getResource("mainLanding-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 956, 956);
        stage.setTitle("Airport Garden Cotizaciones");
        stage.setScene(scene);
        stage.show();
    }
}
