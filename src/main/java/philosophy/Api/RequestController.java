package philosophy.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import philosophy.Wiki.ArticlePath;

@RestController
@RequestMapping("/v1")
public class RequestController {

    @Autowired
    private GetHandler handler;

    @CrossOrigin(origins = "http://localhost:5000")
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public ArticlePath articlePath(@RequestParam(value="page") String page) {
        return handler.processRequest(page);
    }
}
