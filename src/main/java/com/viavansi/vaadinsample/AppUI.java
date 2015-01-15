package com.viavansi.vaadinsample;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("vaadinsample")
@Widgetset("com.viavansi.vaadinsample.AppWidgetSet")
@Title("Vaadin Sample")
@SuppressWarnings("serial")
public final class AppUI extends UI {

    @Override
    protected void init(final VaadinRequest request) {
        
    }
    
}
