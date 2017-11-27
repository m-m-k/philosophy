package philosophy.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import philosophy.Wiki.ArticleClient;
import philosophy.Wiki.ArticlePath;

@Component
public class GetHandler {

    @Autowired
    private ArticleClient articleClient;

    public ArticlePath processRequest(String page) {
        return articleClient.getPath(page);
    }
}
