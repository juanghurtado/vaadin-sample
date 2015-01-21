package com.viavansi.vaadinsample.app;

import javax.servlet.ServletException;

import com.vaadin.server.VaadinServlet;
import com.viavansi.vaadinsample.lib.listener.CustomSessionInitListener;

@SuppressWarnings("serial")
public class AppServlet extends VaadinServlet {

    @Override
    protected final void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new CustomSessionInitListener());
    }
}