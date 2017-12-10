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

    Elements exstractInfo(int numPage);

    String[] printInfo(Element Ad);

    Integer countInfo();

    Integer getMaxSize();

    Integer getMaxPage();
}
