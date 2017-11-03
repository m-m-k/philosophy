package philosophy.Api;

import java.util.ArrayList;

public class Response {

    private final long count;
    private final String page;
    private final ArrayList<String> path;
    private final boolean found;
    private final boolean loop;

    public Response(String page, ArrayList<String> path, long count, boolean found, boolean loop) {
        this.page = page;
        this.path = path;
        this.count = count;
        this.found = found;
        this.loop = loop;
    }

    public long getCount() {
        return count;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public String getPage() {
        return page;
    }

    public boolean getFound() {
        return found;
    }

    public boolean getLoop() {
        return loop;
    }
}
