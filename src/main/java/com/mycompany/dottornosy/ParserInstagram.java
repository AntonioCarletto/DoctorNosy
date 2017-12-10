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
 * La classe Subito implementa l'interfaccia JobAdNoMicro.
 */
public class ParserInstagram implements InfoNoMicro {
   
   
    public static final int MAX_SIZE = 8;
    public static final int MAX_PAGE_SITE = 2350;
    public static final String LFN = ControlPanel.LOG_FILE_NAME;
    public static final boolean LG = ControlPanel.LOG_FLAG;
    
    
    public Document doc;
    public Document docTemp;
    public Elements ads;
    public String[] m;
    public int adCount;
    
    
    
    
    public Document exstractDoc(int page) {


        try {
            doc = Jsoup.connect("http://www.subito.it/annunci-italia/vendita/offerte-lavoro/?o=" + page).get();
        } catch (IOException ex) {
            Logger.getLogger(ParserInstagram.class.getName()).log(Level.SEVERE, null, ex);
        }
        DataLogger.Log(LG,"Sito: http://www.subito.it",LFN);
        DataLogger.Log(LG, "Documento " + "http://www.subito.it/annunci-italia/vendita/offerte-lavoro/?o=" + page + " estratto",LFN);
        return doc;
    }

    public Elements exstractInfo(int page) {

        exstractDoc(page);
        ads = doc.body().select("ul.items_listing").select("li");
        DataLogger.Log(LG, "Annunci estratti dalla pagina " + page + ": " + countInfo(),LFN);
   
        return ads;
    }

    public String[] printInfo(Element Ad) {

        String[] m = new String[MAX_SIZE];

        String title = Ad.select("h2").text();
        m[0] = title;
        String link = Ad.select("h2").select("a[href]").attr("abs:href");
        m[1] = link;
        String place2 = Ad.select("span.item_location").text();
        m[4] = place2;

            try {
                docTemp = Jsoup.connect(m[1]).get();
            } catch (IOException ex) {
                Logger.getLogger(ParserInstagram.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            String company = docTemp.body().select("div.profile").select("div.publisher_info").select("h2").text();
            m[2] = company;
            String contract = docTemp.body().select("div.summary").select("tr:contains(Contratto)").select("td.details_value").text();
            m[3] = contract;
            String description = docTemp.body().select("div.description").text();
            m[5] = description;
            String disposability = docTemp.body().select("div.summary").select("tr:contains(Orario)").select("td.details_value").text();
            String pubblication = "";
            m[6] = disposability;
            m[7] = pubblication;

        return m;
    }

    public Integer countInfo() {
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
