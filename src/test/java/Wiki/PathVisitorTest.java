package Wiki;

import org.junit.Test;
import org.junit.Assert;
import philosophy.Wiki.*;

import java.util.ArrayList;

public class PathVisitorTest {

    private CommonTestObjectFactory commonTestObjectFactory;

    public PathVisitorTest() {
        this.commonTestObjectFactory = new CommonTestObjectFactory();
    }

    @Test
    public void pathTest() {
        PathStringArticleVisitor visitor = new PathStringArticleVisitor();
        Article articleComposite = commonTestObjectFactory.createTestArticleComposite();
        ArrayList<String> expectedStringArray = commonTestObjectFactory.createTestArticleCompositePathStringArray();

        articleComposite.accept(visitor);

        Assert.assertEquals(expectedStringArray, visitor.getPath());
    }
}
