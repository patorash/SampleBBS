package gtug4.controller;

import gtug4.service.BbsService;

import java.util.TimeZone;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("JST"));
        BbsService bbsService = new BbsService();
        requestScope("list", bbsService.getAll());
        return forward("index.jsp");
    }
}
