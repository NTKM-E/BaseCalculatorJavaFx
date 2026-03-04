package nt.basecalulator.basecalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;



public class MainLandingController {
    @FXML
    private TextField fechaEvento;
    @FXML
    private TextField horarioEvento;
    @FXML
    private TextField nombre;
    @FXML
    private TextField paxEvento;
    @FXML
    private TextField precioPlanEscencial;
    @FXML
    private TextField precioPlanSuperior;
    @FXML
    private TextField precioPlanTradicional;
    @FXML
    private TextField tipoEvento;
    @FXML
    private CheckBox alimentacionServicio;
    @FXML
    private CheckBox breakPlanEscencial;
    @FXML
    private CheckBox breakPlanSuperior;
    @FXML
    private CheckBox breakPlanTradicional;
    @FXML
    private CheckBox instalacionesServicio;
    @FXML
    private CheckBox piscinaServicio;
    @FXML
    private CheckBox salonEventosServicio;



    @FXML
    protected void onHelloButtonClick() {
        fechaEvento.setText("Welcome to JavaFX Application!");
    }
}
