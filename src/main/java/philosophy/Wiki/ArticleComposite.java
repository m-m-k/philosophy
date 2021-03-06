package philosophy.Wiki;


import java.util.ArrayList;

public class ArticleComposite implements Article {

    private ArrayList<Article> children;
    private Article parent;

    public ArticleComposite() {
        this.children = new ArrayList<>();
    }

    @Override
    public void accept(ArticleVisitor visitor) {
        for(Article article : children) {
            visitor.visit(article);
        }
    }

    @Override
    public void add(Article article) {
        article.setParent(this);
        children.add(article);
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
        return children;
    }

    @Override
    public String getPageTitle() {
        //return starting page for ArticleComposite
        return children.get(0).getPageTitle();
    }

}
