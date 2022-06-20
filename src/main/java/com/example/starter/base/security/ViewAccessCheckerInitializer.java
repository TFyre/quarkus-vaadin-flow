package com.example.starter.base.security;

import com.example.starter.base.LoginView;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.auth.ViewAccessChecker;

public class ViewAccessCheckerInitializer implements VaadinServiceInitListener {

    private final ViewAccessChecker viewAccessChecker;

    public ViewAccessCheckerInitializer() {
        viewAccessChecker = new ViewAccessChecker();
        viewAccessChecker.setLoginView(LoginView.class);
    }

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        serviceInitEvent.getSource().addUIInitListener(uiInitEvent -> {
            uiInitEvent.getUI().addBeforeEnterListener(viewAccessChecker);
        });
    }
}
