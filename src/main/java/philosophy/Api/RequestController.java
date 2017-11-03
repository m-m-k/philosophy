package philosophy.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RequestController {

    @Autowired
    getHandler handler;

    @CrossOrigin(origins = "http://localhost:5000")
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public Response response(@RequestParam(value="page") String page) {
        return handler.processRequest(page);
    }
}
