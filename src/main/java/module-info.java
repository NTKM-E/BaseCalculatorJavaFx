module nt.basecalulator.basecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens nt.basecalulator.basecalculator to javafx.fxml;
    exports nt.basecalulator.basecalculator;
}