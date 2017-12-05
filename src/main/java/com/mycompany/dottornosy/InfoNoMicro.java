package com.mycompany.dottornosy;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Antonio
 */
/**
 * L'interfaccia JobAdNoMicro definisce gli oggetti ed i metodi per produrre un
 * annucnio senza microdati
 */
public interface InfoNoMicro {

    Document exstractDoc(int page);

    Elements exstractAds(int numPage);

    String[] printAd(Element Ad);

    Integer countAds();

    Integer getMaxSize();

    Integer getMaxPage();
}
