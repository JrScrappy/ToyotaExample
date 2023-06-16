package com.auto_shop.beans;

import com.auto_shop.models.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class HttpSession {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void clear(){
        user = null;
    }

    public boolean isPresent(){
        return user != null;
    }
}
