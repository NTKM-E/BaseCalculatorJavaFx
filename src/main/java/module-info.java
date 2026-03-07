module nt.basecalulator.basecalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires org.apache.logging.log4j;


    opens nt.basecalulator.basecalculator to javafx.fxml;
    exports nt.basecalulator.basecalculator;
}