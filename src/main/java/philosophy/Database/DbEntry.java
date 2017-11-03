package philosophy.Database;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class DbEntry {

    @Id
    public String id;

    public String page;
    public ArrayList<String> path;
    public int count;
    public boolean found;
    public boolean loop;

    public DbEntry(String page, ArrayList<String> path, int count, boolean found, boolean loop) {
        this.page = page;
        this.path = path;
        this.count = count;
        this.found = found;
        this.loop = loop;
    }
}
