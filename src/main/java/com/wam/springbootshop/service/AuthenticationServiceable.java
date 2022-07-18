package com.wam.springbootshop.service;

import com.wam.springbootshop.model.User;

/**
 * @author Wyllian
 */

public interface AuthenticationServiceable {
    User signInAndReturnJWT(User signInRequest);
}
