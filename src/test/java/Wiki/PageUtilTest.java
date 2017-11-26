package Wiki;

import org.junit.Assert;
import org.junit.Test;
import philosophy.Wiki.PageUtil;

public class PageUtilTest {

    @Test
    public void getNextPage() {
        PageUtil pageUtil = new PageUtil();
        Assert.assertEquals("Philosophy", pageUtil.getNextPageString("Idea"));
    }
}
