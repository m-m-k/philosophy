package philosophy.Wiki;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LinkStrategy {

    @Autowired
    private PageFetcher fetcher;

    public String getFirstLink(String page) {
        String doc = null;
        try {
            doc = fetcher.getPage(page);
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
                if(!link.attr("href").contains("#") && checkPage(link.attr("href").replace("/wiki/", ""))) {
                    return link.attr("href").replace("/wiki/", "");
                }

            }
        }

        return "";
    }

    private boolean checkPage(String page) {
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
}
