package gtug4.controller;

import gtug4.service.CommentService;

import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.RequestMap;

public class CommentController extends Controller {

    @Override
    public Navigation run() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("JST"));
        HashMap<String, Object> input = new RequestMap(request);
        String strId = (String)input.get("id");
        if (strId != null && !"".equals(strId)) {
            long id = Long.valueOf(strId);
            if (isPost() && validate()) {
                String token = (String)sessionScope("token");
                if (input.containsKey("token") && token.equals((String)input.get("token"))) {
                    removeSessionScope("token");
                    CommentService commentService = new CommentService();
                    commentService.insert(id, input);
                    return redirect("/read/" + id);
                } else {
                    errors.put("token", ApplicationMessage.get("error.token.invalid"));
                    setToken();
                    return forward("read");
                }
            } else {
                setToken();
                return forward("read");
            }
        } else {
            return redirect("/");
        }
    }
    
    private boolean validate() {
        Validators v = new Validators(request);
        v.add("name", v.required());
        v.add("body", v.required());
        return v.validate();
    }
    
    private void setToken() {
        String token = String.valueOf(new Date().getTime());
        sessionScope("token", token);
        requestScope("token", token);
    }
}
