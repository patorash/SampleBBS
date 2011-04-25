package gtug4.controller;

import gtug4.model.Bbs;
import gtug4.model.Comment;
import gtug4.service.BbsService;
import gtug4.service.CommentService;

import java.util.Date;
import java.util.List;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ReadController extends Controller {

    @Override
    public Navigation run() throws Exception {
        long id = Long.valueOf((String)request.getAttribute("id"));
        BbsService bbsService = new BbsService();
        Bbs bbs = bbsService.getBbs(id);
        CommentService commentService = new CommentService();
        List<Comment> comments = commentService.getAll(id);
        String token = String.valueOf(new Date().getTime());
        requestScope("bbs", bbs);
        requestScope("comments", comments);
        sessionScope("token", token);
        requestScope("token", token);
        return forward("read.jsp");
    }
}
