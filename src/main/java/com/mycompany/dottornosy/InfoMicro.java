package com.mycompany.dottornosy;

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
public interface InfoMicro {

    Document exstractDoc(int page);

    Elements exstractAds(int numPage);

    String[] printAd(Element Ad);

    Integer countAds();

    Integer getMaxSize();

    Integer getMaxPage();
}
