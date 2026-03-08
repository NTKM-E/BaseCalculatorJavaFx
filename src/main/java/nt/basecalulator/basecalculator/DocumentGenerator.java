package nt.basecalulator.basecalculator;
import org.apache.poi.xwpf.usermodel.*;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DocumentGenerator {
    // open document
    // load into XWPFDocument
    // replace text
    // remove sections as needed
    // save to output file
    public static void generate(formData data)throws Exception {
        InputStream template = DocumentGenerator.class.getResourceAsStream("/baseDocument.docx");
        XWPFDocument doc = new XWPFDocument(template);

        for (XWPFParagraph para : doc.getParagraphs()) {
            for (XWPFRun run : para.getRuns()) {
                System.out.println("RUN: [" + run.getText(0) + "]");
            }
        }

        for (XWPFParagraph para : doc.getParagraphs()) {
            for (XWPFRun run : para.getRuns()) {
                String text = run.getText(0);
                if (text != null) {
                    text = text.replace("{{NOMBRE}}", data.nombre);
                    text = text.replace("{{TIPO_DE_EVENTO}}", data.tipoEvento);
                    text = text.replace("{{FECHAS_EVENTO}}", data.fechaEvento);
                    text = text.replace("{{PAX_EVENTO}}", data.paxEvento);
                    text = text.replace("{{HORARIO_EVENTO}}", data.horarioEvento);
                    text = text.replace("{{DATE}}",LocalDate.now().format(DateTimeFormatter.ofPattern("d/M/yyyy")));

                }
                run.setText(text,0);

            }


        }
        List<String[]> sectionMarkersToRemove = new ArrayList<>();
        if (!data.hospedajeCheck) {sectionMarkersToRemove.add(new String[]{"{{START_HOSPEDAJE}}", "{{END_HOSPEDAJE}}"});}
        if (!data.planEscencialCheck) {sectionMarkersToRemove.add(new String[]{"{{START_PLAN_ESCENCIAL}}", "{{END_PLAN_ESCENCIAL}}"});}
        if (!data.planTradicionalCheck) {sectionMarkersToRemove.add(new String[]{"{{START_PLAN_TRADICIONAL}}", "{{END_PLAN_TRADICIONAL}}"});}
        if (!data.planParrilleroCheck) {sectionMarkersToRemove.add(new String[]{"{{START_PLAN_PARRILLERO}}", "{{END_PLAN_PARRILLERO}}"});}
        List<XWPFParagraph> toRemove = new ArrayList<>();
        String endMarker = null;

        for (XWPFParagraph paragraph: doc.getParagraphs()){
            String text = paragraph.getText();
            for (String[] markers : sectionMarkersToRemove){
                if (text.contains(markers[0])){
                    endMarker = markers[1];
                }
                if (endMarker!=null){
                    toRemove.add(paragraph);
                    if (text.contains(endMarker)){
                        endMarker = null;
                    }
                }

            }
        }
        for (XWPFParagraph paragraphToEliminate : toRemove){
            doc.removeBodyElement(doc.getPosOfParagraph(paragraphToEliminate));
        }
        FileOutputStream output = new FileOutputStream("output.docx");
        doc.write(output);
        output.close();
        doc.close();





        }
}



