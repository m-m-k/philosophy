package philosophy.Wiki;

import java.util.ArrayList;

public class ArticleLeaf implements Article {

    private String title;
    private Article parent;

    public ArticleLeaf(String title) {
        this.title = title;
    }

    @Override
    public void accept(ArticleVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void add(Article article) {
        //nothing to do here in leaf node
    }

    @Override
    public void setParent(Article article) {
        this.parent = article;
    }

    @Override
    public Article getParent() {
        return parent;
    }

    @Override
    public ArrayList<Article> getChildren() {
        return null;
    }

    @Override
    public String getPageTitle() {
        return title;
    }

}
