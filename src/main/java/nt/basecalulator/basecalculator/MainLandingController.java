package nt.basecalulator.basecalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private CheckBox prefixEstimado;
    @FXML
    private CheckBox prefixEstimada;
    @FXML
    private CheckBox prefixEstimados;
    @FXML
    private CheckBox hospedajeCheck;
    @FXML
    private CheckBox planEscencialCheck;
    @FXML
    private CheckBox planTradicionalCheck;
    @FXML
    private CheckBox planParrilleroCheck;
    @FXML
    private Button generarButton;

    formData data = new formData();

    protected void setData() {
        data.nombre = nombre.getText();
        data.fechaEvento = fechaEvento.getText();
        data.horarioEvento = horarioEvento.getText();
        data.paxEvento = paxEvento.getText();
        data.precioPlanEscencial = precioPlanEscencial.getText();
        data.precioPlanSuperior = precioPlanSuperior.getText();
        data.precioPlanTradicional = precioPlanTradicional.getText();
        data.tipoEvento = tipoEvento.getText();
        data.alimentacionServicio = alimentacionServicio.isSelected();
        data.breakPlanEscencial = breakPlanEscencial.isSelected();
        data.breakPlanSuperior = breakPlanSuperior.isSelected();
        data.breakPlanTradicional = breakPlanTradicional.isSelected();
        data.instalacionesServicio = instalacionesServicio.isSelected();
        data.piscinaServicio = piscinaServicio.isSelected();
        data.salonEventosServicio = salonEventosServicio.isSelected();
        data.prefixEstimado = prefixEstimado.isSelected();
        data.prefixEstimada = prefixEstimada.isSelected();
        data.prefixEstimados = prefixEstimados.isSelected();
        data.hospedajeCheck = hospedajeCheck.isSelected();
        data.planEscencialCheck = planEscencialCheck.isSelected();
        data.planTradicionalCheck = planTradicionalCheck.isSelected();
        data.planParrilleroCheck = planParrilleroCheck.isSelected();

    }
    @FXML
    private void setAndGenerate()throws Exception {
        setData();
        DocumentGenerator.generate(data);
    }
}

