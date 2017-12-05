package com.mycompany.dottornosy;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Antonio
 */
public class DateAndTime {

    public static String PrintDateTime() {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy – HH:mm:ss");
        String dateTime = sdf.format(gc.getTime());

        return dateTime;

    }

    public static String PrintTime() {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(gc.getTime());
 
        return time;

    }

    public static String PrintDate() {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(gc.getTime());

        return date;

    }
    
        public static String PDTBritish() {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTime = sdf.format(gc.getTime());

        return dateTime;

    }
}
