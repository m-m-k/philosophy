package philosophy.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import philosophy.Database.DbClient;
import philosophy.Database.DbEntry;
import philosophy.Wiki.WikiCrawler;

@Component
public class GetHandler {
    @Autowired
    private DbClient dbClient;

    @Autowired
    private WikiCrawler wikiCrawler;

    public Response processRequest(String page) {
        wikiCrawler.crawl(page);
        DbEntry entry = dbClient.getDoc(page);
        return new Response(page, entry.path, entry.count, entry.found, entry.loop);
    }
}
