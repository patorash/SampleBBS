package gtug4.controller;

import gtug4.service.BbsService;

import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class CreateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("JST"));
        String token = String.valueOf(new Date().getTime());
        if (isPost()) {
            if (validate()) {
                // トークンの確認
                HashMap<String, Object> input = new RequestMap(request);
                String sessionToken = (String)sessionScope("token");
                if (sessionToken != null && sessionToken.equals(input.get("token").toString())) {
                    removeSessionScope("token");
                    BbsService bbsService = new BbsService();
                    bbsService.insert(input);
                    return redirect("/");
                } else {
                    // 不正投稿の可能性
                    return forward("duplicate.jsp");
                }
            } else {
                // エラーが検出された
                sessionScope("token", token);
                requestScope("token", token);
                return forward("create.jsp");
            }
        } else {
            sessionScope("token", token);
            requestScope("token", token);
            return forward("create.jsp");
        }
    }
    
    private boolean validate() {
        Validators v = new Validators(request);
        v.add("name", v.required());
        v.add("title", v.required());
        v.add("body", v.required());
        return v.validate();
    }
}
