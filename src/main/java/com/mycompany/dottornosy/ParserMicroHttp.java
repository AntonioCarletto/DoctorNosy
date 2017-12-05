package com.mycompany.dottornosy;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




/**
 *
 * @author Antonio
 */
/**
 * 
 */
public class ParserMicroHttp implements InfoMicro {

    
    private static final int MAX_SIZE = 8;
    private static final int MAX_PAGE_SITE = 214500000;
    private static final String LFN = ControlPanel.LOG_FILE_NAME;
    private static final boolean LG = ControlPanel.LOG_FLAG;
    
    
    private Document doc;
    private Elements ads;
    private int adCount;
    
    
    
    
    public Document exstractDoc(int page) {


        try {
            doc = Jsoup.connect(/** Inserire il sito a cui connettersi per estrarre**/"").get();
        } catch (IOException ex) {
            Logger.getLogger(ParserMicroHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataLogger.Log(LG,"Sito: ",LFN);
        DataLogger.Log(LG, "Pagina " + "" + page + "/" + " estratto",LFN);
        return doc;
    }

    public Elements exstractAds(int page) {

        exstractDoc(page);
        ads = doc.body().select(/** Inserire l'informazione generica da estrarre **/"");
        DataLogger.Log(LG, "Informazioni estratte dalla pagina " + page + ": " + countAds(),LFN);
        return ads;
    }

    public String[] printAd(Element Ad) {

        String[] m = new String[MAX_SIZE];

        String title = Ad.select(/** Inserire tag da selezionare**/"").text();
        m[0] = title;
        String link = Ad.select(/** Inserire tag da selezionare**/"").select(/** Inserire tag da selezionare**/"").attr(/** Inserire tag da selezionare**/"");
        m[1] = link;
        String company = Ad.select(/** Inserire tag da selezionare**/"").text();
        m[2] = company;
        String contract = Ad.select(/** Inserire tag da selezionare**/"").text();
        m[3] = contract;
        String place = Ad.select(/** Inserire tag da selezionare**/"").text();
        m[4] = place;
        String description = Ad.select(/** Inserire tag da selezionare**/"").text();
        m[5] = description;
        String disposability = Ad.select(/** Inserire tag da selezionare**/"").text();
        m[6] = disposability;
           


        return m;
    }

    public Integer countAds() {
        adCount = ads.size();
        return adCount;

    }

    public Integer getMaxSize() {
       return MAX_SIZE;
    }

    public Integer getMaxPage() {
        return MAX_PAGE_SITE;
    }
}