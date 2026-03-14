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


        Map<String, String> fields = new HashMap<>();
        fields.put("{{NOMBRE}}", data.nombre);
        fields.put("{{TIPO_DE_EVENTO}}", data.tipoEvento);
        fields.put("{{FECHAS_EVENTO}}", data.fechaEvento);
        fields.put("{{PAX_EVENTO}}", data.paxEvento);
        fields.put("{{HORARIO_EVENTO}}", data.horarioEvento);
        fields.put("{{DATE}}",LocalDate.now().format(DateTimeFormatter.ofPattern("d/M/yyyy")));
        for (XWPFParagraph paragraph : doc.getParagraphs()) {
            replaceParagraph(paragraph,fields);
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

        public static void  replaceParagraph(XWPFParagraph paragraph, Map<String, String> fields){
            StringBuilder stringBuild = new StringBuilder();
            for (XWPFRun run :paragraph.getRuns()){
                if (run.getText(0) != null ){
                    stringBuild.append(run.getText(0));
                }
            }
            String allText = stringBuild.toString();
            for(Map.Entry<String, String> entry: fields.entrySet()){
                allText = allText.replace(entry.getKey(),entry.getValue());
            }
            for (int i =0;i < paragraph.getRuns().size(); i++){
                paragraph.getRuns().get(i).setText(i==0?allText:"",0);



            }






        }
}



