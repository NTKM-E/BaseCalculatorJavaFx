package nt.basecalulator.basecalculator;
import org.apache.poi.xwpf.usermodel.*;
import java.io.*;
import java.util.*;

public class DocumentGenerator {
    // open document
    // load into XWPFDocument
    // replace text
    // remove sections as needed
    // save to output file
    public static void generate(Map<String,String> fields)throws Exception{
    InputStream template =DocumentGenerator.class.getResourceAsStream("/baseDocument");
    XWPFDocument doc = new XWPFDocument(template);


    }

}
