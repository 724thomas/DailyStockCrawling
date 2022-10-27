package jav;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class StockCrawling {

    public static String getCompanyFromUrl(String URL){
        Document doc;
        try{
            doc = Jsoup.connect(URL).get();
            Elements name = doc.select("#middle > div.h_company > div.wrap_company > h2 > a");
            return name.get(0).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
}