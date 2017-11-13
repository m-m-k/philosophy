package philosophy.Wiki;

import java.util.ArrayList;

public class ArticlePath {

    String title;
    ArrayList<String> path;
    Boolean found;
    Boolean loop;

    public ArticlePath(String title, ArrayList<String> path, Boolean found, Boolean loop) {
        this.title = title;
        this.path = path;
        this.found = found;
        this.loop = loop;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public Boolean getFound() {
        return found;
    }

    public Boolean getLoop() {
        return loop;
    }
}
