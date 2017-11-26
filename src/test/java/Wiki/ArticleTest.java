package Wiki;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import philosophy.Wiki.Article;
import philosophy.Wiki.ArticleComposite;
import philosophy.Wiki.ArticleLeaf;


public class ArticleTest {

    private CommonTestObjectFactory commonTestObjectFactory;

    public ArticleTest() {
        this.commonTestObjectFactory = new CommonTestObjectFactory();
    }

    @Test
    public void createArticleLeaf() {
        Article article = new ArticleLeaf("test");
        Assert.assertEquals("test", article.getPageTitle());
    }

    @Test
    public void createArticleComposite() {
        Article articleComposite = new ArticleComposite();
        Article article = new ArticleLeaf("test");
        articleComposite.add(article);

        Assert.assertTrue(articleComposite.getChildren().contains(article));
    }

    @Test
    public void addArticleLeaf() {
        Article hello = new ArticleComposite();
        Article world = new ArticleLeaf("world");
        hello.add(world);

        Assert.assertTrue(hello.getChildren().contains(world));
    }

    @Test
    public void addArticleComposite() {
        Article helloComposite = commonTestObjectFactory.createTestArticleComposite();
        Article worldComposite = commonTestObjectFactory.createTestArticleComposite();

        helloComposite.add(worldComposite);

        Assert.assertTrue(helloComposite.getChildren().contains(worldComposite));
    }

}
