package Wiki;

import org.junit.Test;
import org.junit.Assert;

import philosophy.Wiki.Article;
import philosophy.Wiki.ArticleComposite;
import philosophy.Wiki.ArticleLeaf;


public class ArticleTest {

    @Test
    public void createArticleLeaf() {
        Article article = new ArticleLeaf("test");
        Assert.assertEquals("test", article.getPageTitle());
    }

    @Test
    public void createArticleComposite() {
        Article article = new ArticleComposite("test");
        Assert.assertEquals("test", article.getPageTitle());
    }

    @Test
    public void addArticleLeaf() {
        Article hello = new ArticleComposite("hello");
        Article world = new ArticleLeaf("world");
        hello.add(world);

        Assert.assertTrue(hello.getChildren().contains(world));
    }

    @Test
    public void addArticleComposite() {
        Article hello = new ArticleComposite("hello");
        Article world = new ArticleComposite("world");
        hello.add(world);

        Assert.assertTrue(hello.getChildren().contains(world));
    }

}
