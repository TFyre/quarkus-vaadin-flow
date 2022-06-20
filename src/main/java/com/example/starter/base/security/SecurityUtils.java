package com.example.starter.base.security;

import com.example.starter.base.MainView;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.server.VaadinServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class SecurityUtils {

    public static boolean isLoggedIn() {
        return VaadinServletRequest.getCurrent().getUserPrincipal() != null;
    }

    public static boolean login(final String username, final String password) {
        try {
            VaadinServletRequest.getCurrent().login(username, password);
            Notification.show("OK");
            return true;
        } catch (NullPointerException | ServletException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            Notification.show(String.format("ERROR: %s", ex.getMessage()));
            return false;
        }
    }

    public static void logout() {
        VaadinServletRequest.getCurrent().getSession().invalidate();
    }
}
