package Wiki;

import org.junit.Test;
import org.junit.Assert;
import philosophy.Wiki.*;

import java.util.ArrayList;

public class ArticleManagerTest {

    @Test
    public void crawlTest () {
        ArticleManager articleManager = new ArticleManager();
        ArticlePath path = articleManager.getPath("Idea");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Idea");
        expected.add("Philosophy");

        Assert.assertEquals(expected, path.getPath());
    }
}
