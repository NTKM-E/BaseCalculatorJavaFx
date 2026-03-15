package nt.basecalulator.basecalculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

import java.util.List;


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
    private TextField precioHospedajeSimple;
    @FXML
    private TextField precioHospedajeDoble;
    @FXML
    private TextField precioHospedajeMultiple;
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
    private CheckBox alimentacionCheck;
    @FXML
    private CheckBox hospedajeSimple;
    @FXML
    private CheckBox hospedajeDoble;
    @FXML
    private CheckBox hospedajeMultiple;

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
        data.precioHospedajeSimple = precioHospedajeSimple.getText();
        data.precioHospedajeDoble = precioHospedajeDoble.getText();
        data.precioHospedajeMultiple = precioHospedajeMultiple.getText();

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
    @FXML
    public void initialize(){
        prefixEstimado.selectedProperty().addListener((obs, oldVal, newVal)->{
            if (newVal){
                prefixEstimada.setSelected(false);
                prefixEstimados.setSelected(false);
            }
        }
        );
        prefixEstimada.selectedProperty().addListener((obs, oldVal, newVal)->{
                    if (newVal){
                        prefixEstimado.setSelected(false);
                        prefixEstimados.setSelected(false);
                    }
                }
        );
        prefixEstimados.selectedProperty().addListener((obs, oldVal, newVal)->{
                    if (newVal){
                        prefixEstimada.setSelected(false);
                        prefixEstimado.setSelected(false);
                    }
                }
        );
//Disabling Checkboxes unless parent is available
//Current parent Child relation
//alimentacionCheck - > (Plan EscencialCheck, TradicionalCheck, planParrilleroCheck)->(respective breakCheck)
//hospedaje -> (Hospedaje Simple,Hospedaje Doble, Hospedaje Multiple)



        planEscencialCheck.setDisable(true);
        planTradicionalCheck.setDisable(true);
        planParrilleroCheck.setDisable(true);
        breakPlanEscencial.setDisable(true);
        breakPlanTradicional.setDisable(true);
        breakPlanSuperior.setDisable(true);

        hospedajeSimple.setDisable(true);
        hospedajeDoble.setDisable(true);
        hospedajeMultiple.setDisable(true);

        precioPlanEscencial.setDisable(true);
        precioPlanSuperior.setDisable(true);
        precioPlanTradicional.setDisable(true);
        precioHospedajeSimple.setDisable(true);
        precioHospedajeDoble.setDisable(true);
        precioHospedajeMultiple.setDisable(true);

        breakPlanEscencial.setSelected(false);
        breakPlanSuperior.setSelected(false);
        breakPlanTradicional.setSelected(false);




        setParentChild(alimentacionCheck,List.of(planEscencialCheck,planParrilleroCheck,planTradicionalCheck),List.of());
        setParentChild(planEscencialCheck,List.of(breakPlanEscencial),List.of(precioPlanEscencial));
        setParentChild(planParrilleroCheck,List.of(breakPlanSuperior),List.of(precioPlanSuperior));
        setParentChild(planTradicionalCheck,List.of(breakPlanTradicional),List.of(precioPlanTradicional));
        setParentChild(hospedajeCheck,List.of(hospedajeSimple,hospedajeDoble,hospedajeMultiple),List.of());
        setParentChild(hospedajeSimple,List.of(),List.of(precioHospedajeSimple));
        setParentChild(hospedajeDoble,List.of(),List.of(precioHospedajeDoble));
        setParentChild(hospedajeMultiple,List.of(),List.of(precioHospedajeMultiple));

    }
    public void setParentChild(CheckBox parent, List<CheckBox> childCheckBoxes,List<TextField> childTextField){
        parent.selectedProperty().addListener((obs,oldVal,newVal)->{
            for (CheckBox child:childCheckBoxes){
                    child.setDisable(!newVal);
                    child.setSelected(newVal);
            }
            for (TextField childField : childTextField){
                childField.setDisable(!newVal);

            }
        });




    }
}


