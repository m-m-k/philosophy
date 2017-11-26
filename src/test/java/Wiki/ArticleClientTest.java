package Wiki;

import org.junit.Test;
import org.junit.Assert;
import philosophy.Wiki.*;

import java.util.ArrayList;

public class ArticleClientTest {

    @Test
    public void crawlTest () {
        ArticleClient articleClient = new ArticleClient();
        ArticlePath path = articleClient.getPath("Idea");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Idea");
        expected.add("Philosophy");

        Assert.assertEquals(expected, path.getPath());
    }
}
