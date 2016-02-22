package com.jpl.util.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.jpl.ui.model.ClientDm;
import com.jpl.ui.model.UserDm;

@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final Locale locale;
    private final ClientDm clientDm;
    private final UserDm userDm;

    public OnRegistrationCompleteEvent(final ClientDm clientDm, final UserDm userDm, final Locale locale, final String appUrl) {
        
    	super((clientDm==null)?userDm:clientDm);
        this.clientDm = clientDm;
        this.userDm = userDm;
        this.locale = locale;
        this.appUrl = appUrl;
    }

	public String getAppUrl() {
		return appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public ClientDm getClientDm() {
		return clientDm;
	}

	public UserDm getUserDm() {
		return userDm;
	}
}
