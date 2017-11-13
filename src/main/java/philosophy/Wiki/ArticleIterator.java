package philosophy.Wiki;

import java.util.Iterator;

public class ArticleIterator implements Iterator<Article> {

    Article article;
    ArticleIteratorStrategy strategy;
    Integer cursor;

    public ArticleIterator(Article article, ArticleIteratorStrategy strategy) {
        this.article = article;
        this.strategy = strategy;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if(cursor >= article.getChildren().size()) {
            return false;
        } else return !strategy.isDone(article.getChildren().get(cursor));
    }

    @Override
    public Article next() {
        cursor++;
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
