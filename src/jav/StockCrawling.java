package jav;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StockCrawling {

    public static Company getCompanyDataFromUrl(String URL) {
        Document doc;
        Company newCompany = new Company();

        try{
            doc = Jsoup.connect(URL).get();
            Elements todaylist =doc.select(".new_totalinfo dl>dd");

            String companyName=doc.select("#middle > div.h_company > div.wrap_company > h2 > a").get(0).text();
            float juga = Float.parseFloat(todaylist.get(3).text().split(" ")[1].replace(",",""));
            float DungRakrate = Float.parseFloat(todaylist.get(3).text().split(" ")[6]);
            float siga =  Float.parseFloat(todaylist.get(5).text().split(" ")[1].replace(",",""));
            float goga = Float.parseFloat(todaylist.get(6).text().split(" ")[1].replace(",",""));
            float zeoga = Float.parseFloat(todaylist.get(8).text().split(" ")[1].replace(",",""));
            float georaeryang = Float.parseFloat(todaylist.get(10).text().split(" ")[1].replace(",",""));
            String stype = todaylist.get(3).text().split(" ")[3]; //???,??,??,???,?? ??
            float vsyesterday = Float.parseFloat(todaylist.get(3).text().split(" ")[4].replace(",",""));
            String date = doc.select(".date").text().split(" ")[0];

            newCompany.setCompanyNameAndDate(companyName+date);
            newCompany.setCompanyName(companyName);
            newCompany.setUrl(URL);
            newCompany.setJuga(juga);
            newCompany.setDungrakRate(DungRakrate);
            newCompany.setSiga(siga);
            newCompany.setGoga(goga);
            newCompany.setZeoga(zeoga);
            newCompany.setGeoraeryang(georaeryang);
            newCompany.setStype(stype);
            newCompany.setVsyesterday(vsyesterday);
            newCompany.setDate(date);
            return newCompany;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}