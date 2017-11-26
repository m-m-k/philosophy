package Wiki;

import philosophy.Wiki.*;

import java.util.ArrayList;

public class CommonTestObjectFactory {

    public Article createTestArticleComposite() {
        Article hello = new ArticleComposite();
        Article world = new ArticleLeaf("world");
        Article fizz = new ArticleLeaf("fizz");
        Article buzz = new ArticleLeaf("buzz");
        Article foo = new ArticleComposite();
        Article bar = new ArticleLeaf("bar");

        hello.add(world);
        hello.add(fizz);
        hello.add(buzz);
        foo.add(bar);
        hello.add(foo);

        return hello;
    }

    public ArrayList<String> createTestArticleCompositePathStringArray() {
        ArrayList<String> path = new ArrayList<>();
        path.add("world");
        path.add("fizz");
        path.add("buzz");
        path.add("bar");

        return path;
    }
}
