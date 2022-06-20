package com.example.starter.base;

import com.example.starter.base.security.SecurityUtils;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private static final String LOGIN_SUCCESS_URL = "/";

    private final LoginForm login = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setAlignItems(FlexComponent.Alignment.CENTER);

        login.addLoginListener(this::onLogin);
        login.addForgotPasswordListener(this::onForgotPassword);

        add(new H1("Test Application"), login);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation()
            .getQueryParameters()
            .getParameters()
            .containsKey("error")) {
            login.setError(true);
        } else if (SecurityUtils.isLoggedIn()) {
            UI.getCurrent().getPage().setLocation(LOGIN_SUCCESS_URL);
        }
    }

    private void onLogin(AbstractLogin.LoginEvent event) {
        boolean authenticated = SecurityUtils.login(event.getUsername(), event.getPassword());
        if (authenticated) {
            UI.getCurrent().getPage().setLocation(LOGIN_SUCCESS_URL);
        } else {
            login.setError(true);
        }
    }

    private void onForgotPassword(AbstractLogin.ForgotPasswordEvent event) {
        Notification.show("forgotpassword clicked");
    }

}
