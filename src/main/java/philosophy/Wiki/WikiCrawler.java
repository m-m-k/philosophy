package philosophy.Wiki;

import philosophy.Database.DbClient;
import philosophy.Database.DbEntry;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WikiCrawler {

    @Autowired
    private LinkStrategy linkStrategy;

    @Autowired
    private DbClient dbClient;

    private String start;
    private ArrayList<String> path;
    private boolean loop = false;
    private boolean found = false;


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

    public void crawl(String start) {
        this.start = start;
        this.path = new ArrayList<>();
        this.found = false;
        this.loop = false;

        findPath(start);

        dbClient.insertPath(this.path, this.found, this.loop);
    }

    private DbEntry findPath(String page) {
        if(!checkPage(page)) {
            this.found = false;
            this.loop = false;
            this.path.add(page);
            return new DbEntry(this.start, this.path, this.path.size(), this.found, this.loop);
        }
        DbEntry entry = dbClient.getDoc(page);
        if(entry != null) {
            ListIterator iterator = entry.path.listIterator();
            while(iterator.hasNext()) {
                iterator.next();
                this.path.add(entry.path.get(0));
                iterator.remove();
            }
            this.found = entry.found;
            this.loop = entry.loop;

            return new DbEntry(this.start, this.path, this.path.size(), this.found, this.loop);
        }

        if(Objects.equals(page, "Philosophy")) {
            this.found = true;
            this.loop = false;
            this.path.add(page);
            return new DbEntry(this.start, this.path, this.path.size(), this.found, this.loop);
        }

        if(this.path.contains(page)) {
            this.loop = true;
            this.path.add(page);
            return new DbEntry(this.start, this.path, this.path.size(), this.found, this.loop);
        }

        this.path.add(page);

        return findPath(linkStrategy.getFirstLink(page));
    }

}
