package philosophy.Wiki;

import java.util.Objects;

public class ArticleClient {

    private PageUtil pageUtil;

    public ArticleClient() {
        //TODO: Pass some config object?
        this.pageUtil = new PageUtil();
    }

    public ArticlePath getPath(String startingPageString) {
        Article articleComposite = new ArticleComposite();
        Article article = new ArticleLeaf(startingPageString);

        articleComposite.add(article);

        while(!isTargetReached(article)) {
            //TODO: add DB caching and check for cached next article
            article = new ArticleLeaf(pageUtil.getNextPageString(article.getPageTitle()));
            articleComposite.add(article);
        }

        PathStringArticleVisitor articleVisitor = new PathStringArticleVisitor();
        articleComposite.accept(articleVisitor);

        return new ArticlePath(startingPageString, articleVisitor.getPath(), true, false);
    }

    private Boolean isTargetReached(Article article) {
        //TODO: check for loop conditions
        return Objects.equals(article.getPageTitle(), "Philosophy");
    }

}
