package philosophy.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import philosophy.Database.DbClient;
import philosophy.Database.DbEntry;
import philosophy.Wiki.WikiCrawler;

@Component
public class getHandler {
    @Autowired
    private DbClient dbClient;

    @Autowired
    private WikiCrawler wikiCrawler;

    public Response processRequest(String page) {
        DbEntry entry;
        wikiCrawler.crawl(page);
        entry = dbClient.getDoc(page);
        return new Response(page, entry.path, entry.path.size(), entry.found, entry.loop);
    }

}
