package com.mycompany.dottornosy;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Antonio
 */
public class CsvWriting {
    
    
    public static String [] temp;

    public static void csvWriter(String[] arrayAd, int size, String fileName) {
        
        
        temp = new String[size];
        temp = arrayAd;

        
        String outputFile = fileName;
        boolean alreadyExists = new File(outputFile).exists();



        try {
            // Utilizza il costruttore di FileWriter che specifica l'apertura per l'aggiunta
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');
            
            

            // Se il file non esiste ancora, scrive la linea di intestazione
            if (!alreadyExists) {
       
                csvOutput.write("TITLE");
                csvOutput.write("LINK");
                csvOutput.write("COMPANY");
                csvOutput.write("CONTRACT");
                csvOutput.write("PLACE");
                csvOutput.write("DESCRIPTION");
                csvOutput.write("DISPOSABILITY");
                csvOutput.write("PUBLICATION");
                csvOutput.endRecord();
            }
            // Altrimenti assume che il file ha già la linea di intestazione corretta

            // Scrive i record
            
            csvOutput.write(temp[0]);
            csvOutput.write(temp[1]);
            csvOutput.write(temp[2]);
            csvOutput.write(temp[3]);
            csvOutput.write(temp[4]);
            csvOutput.write(temp[5]);
            csvOutput.write(temp[6]);
            csvOutput.write(temp[7]);
            
            csvOutput.endRecord();


            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
