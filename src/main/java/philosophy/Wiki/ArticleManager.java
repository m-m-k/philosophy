package philosophy.Wiki;

import java.util.ArrayList;
import java.util.Objects;

public class ArticleManager {

    public ArticleManager() {    }

    public ArticlePath getPath(String start) {
        Article article = new ArticleComposite(start);
        PageUtil pageUtil = new PageUtil();

        Article next = getLatestArticle(article);

        while(!isTargetReached(next)) {
            next = new ArticleLeaf(pageUtil.getNextPage(next.getPageTitle()));
            article.add(next);
        }

        //TODO: need to create return object
        return null;
    }

    //TODO: implement something better to get latest child.
    private Article getLatestArticle(Article article) {
        ArrayList<Article> nodes = article.getChildren();
        return nodes.get(nodes.size() - 1);

    }

    private Boolean isTargetReached(Article article) {
        return Objects.equals(article.getPageTitle(), "Philosophy");
    }
}
