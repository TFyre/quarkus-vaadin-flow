package com.example.starter.base;

import com.example.starter.base.security.SecurityUtils;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("")
@AnonymousAllowed
public class MainView extends VerticalLayout {

    public MainView() {
        add(new Span("mainView"));
        add(new RouterLink("Admin View", AdminView.class));
        if (SecurityUtils.isLoggedIn()) {
            add(new Button("logout", e -> SecurityUtils.logout()));
        } else {
            add(new RouterLink("Login", LoginView.class));
        }
    }

}
