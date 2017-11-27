package philosophy.Wiki;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ArticleClient {

    private PageUtil pageUtil;
    private ArticleComposite articleComposite;
    private Boolean found;
    private Boolean loop;

    public ArticleClient() {
        //TODO: Pass some config object?
        this.pageUtil = new PageUtil();
    }

    public ArticlePath getPath(String startingPageString) {
        this.articleComposite = new ArticleComposite();
        this.found = false;
        this.loop = false;
        Article article = new ArticleLeaf(startingPageString);


        while(!isTargetReached(article)) {
            //TODO: add DB caching and check for cached next article
            articleComposite.add(article);
            article = new ArticleLeaf(pageUtil.getNextPageString(article.getPageTitle()));
        }

        articleComposite.add(article);

        PathStringArticleVisitor articleVisitor = new PathStringArticleVisitor();
        articleComposite.accept(articleVisitor);

        return new ArticlePath(startingPageString, articleVisitor.getPath(), found, loop);
    }

    private Boolean isTargetReached(Article article) {
        //TODO: check for loop conditions
        this.found = Objects.equals(article.getPageTitle(), "Philosophy");
        this.loop = articleComposite.getChildren().contains(article);

        return found || loop;
    }

}
