package philosophy.Wiki;

import java.util.ArrayList;

public class ArticlePath {

    private String title;
    private ArrayList<String> path;
    private Boolean found;
    private Boolean loop;
    private Integer count;

    public ArticlePath(String title, ArrayList<String> path, Boolean found, Boolean loop) {
        this.title = title;
        this.path = path;
        this.count = path.size();
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

    public Integer getCount() { return count; }
}
