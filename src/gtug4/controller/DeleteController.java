package gtug4.controller;

import gtug4.model.Bbs;
import gtug4.service.BbsService;

import java.util.Date;
import java.util.HashMap;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.RequestMap;

public class DeleteController extends Controller {

    @Override
    public Navigation run() throws Exception {
        HashMap<String, Object> input = new RequestMap(request);
        String strId = (String)input.get("id");
        if (strId != null && !"".equals(strId)) {
            long id = Long.valueOf(strId);
            if (isPost() && validate()) {
                String token = (String)sessionScope("token");
                if (input.containsKey("token") && token.equals((String)input.get("token"))) {
                    removeSessionScope("token");
                    BbsService bbsService = new BbsService();
                    Bbs bbs = bbsService.getBbs(id);
                    String password = (String)input.get("password");
                    if (bbs.getPassword().equals(password)) {
                        bbsService.deleteBbs(id);
                        return redirect("/");
                    } else {
                        errors.put("password", ApplicationMessage.get("error.password.invalid"));
                        setToken();
                        return forward("read");
                    }
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
        v.add("password", v.required());
        return v.validate();
    }

    private void setToken() {
        String token = String.valueOf(new Date().getTime());
        sessionScope("token", token);
        requestScope("token", token);
    }

}
