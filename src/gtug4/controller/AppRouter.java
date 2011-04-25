package gtug4.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {
    
    public AppRouter() {
        addRouting("/read/{id}", "/read?id={id}");
        addRouting("/delete/{id}", "/delete?id={id}");
        addRouting("/comment/{id}", "/comment?id={id}");
    }
}
