package philosophy.Wiki;

import java.util.ArrayList;

public class PathStringArticleVisitor implements ArticleVisitor {

    private ArrayList<String> path;

    public PathStringArticleVisitor() {
        this.path = new ArrayList<>();
    }

    @Override
    public void visit(Article article) {
        path.add(article.getPageTitle());
    }

    public ArrayList<String> getPath() {
        return path;
    }

}
