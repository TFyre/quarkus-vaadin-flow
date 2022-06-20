package com.example.starter.base;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import javax.annotation.security.RolesAllowed;

@Route("/admin")
@RolesAllowed("admin")
public class AdminView extends VerticalLayout {

    public AdminView() {
        add(new Span("adminView"));
        add(new RouterLink("Main View", MainView.class));
    }

}
