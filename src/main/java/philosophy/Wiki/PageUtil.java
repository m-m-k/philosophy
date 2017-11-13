package philosophy.Wiki;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class PageUtil {



    public PageUtil(){    }

    private String getPageAsString(String title) throws IOException{
        URL url = null;
        try {
            url = new URL("https://en.wikipedia.org/wiki/" + title);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        if (conn.getResponseCode() != 200) {
            return  "";
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String str;
        StringBuilder doc = new StringBuilder();
        while((str = br.readLine()) != null) {
            doc.append(str);
        }
        br.close();

        conn.disconnect();

        return doc.toString();
    }

    private boolean validatePage(String page) {
        if(page.isEmpty()) {
            return false;
        }

        String [] bad = {"Wikipedia:", "Help:", "wiktionary"};

        for (String item: bad) {
            if (page.contains(item)) {
                return false;
            }
        }

        return true;
    }

    public String getNextPage(String title) {
        String doc = null;
        try {
            doc = getPageAsString(title);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        if(doc == null) {
            return "";
        }

        //Remove all links from inside parentheses and parse page
        Element document = Jsoup.parse(doc.replaceAll("(<a.*?</a>)|<i>.*?</i>|<tr>[\\s\\S]*?</tr>|\\(.*?\\) ?", "$1"));
        org.jsoup.select.Elements paragraphs = document.select("p, ul");

        for (Element paragraph: paragraphs) {
            org.jsoup.select.Elements links = paragraph.select("a[href]");

            for (Element link: links) {
                if(!link.attr("href").contains("#") && validatePage(link.attr("href").replace("/wiki/", ""))) {
                    return link.attr("href").replace("/wiki/", "");
                }

            }
        }

        return "";
    }
}
