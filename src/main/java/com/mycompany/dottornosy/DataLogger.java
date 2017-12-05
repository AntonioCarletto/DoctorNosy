package com.mycompany.dottornosy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Antonio
 */
public class DataLogger {

    public static String notify;
    public static final String NEWLINE = System.getProperty("line.separator");

 
    public static void Log(boolean consoleFlag, String message, String name) {



        try {
            notify = DateAndTime.PrintDateTime() + " - " + "Log Notify: " + message;
            File file = new File(name);
            if (file.exists()) {
                FileWriter fw = new FileWriter(name, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(notify + NEWLINE);
                bw.close();
            } else {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(notify + NEWLINE);
                bw.flush();
                bw.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        if (consoleFlag == true) {
            StampLogConsole();
        }



    }

    public static void StampLogConsole() {

        System.out.println(notify);

    }
}
