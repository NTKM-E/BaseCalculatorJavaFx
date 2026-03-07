module nt.basecalulator.basecalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;


    opens nt.basecalulator.basecalculator to javafx.fxml;
    exports nt.basecalulator.basecalculator;
}