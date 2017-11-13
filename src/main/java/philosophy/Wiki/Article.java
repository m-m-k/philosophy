package philosophy.Wiki;

import java.util.ArrayList;

public interface Article {
    void accept(ArticleVisitor visitor);
    void add(Article article);
    void setParent(Article article);
    Article getParent();
    ArrayList<Article> getChildren();
    String getPageTitle();
}
